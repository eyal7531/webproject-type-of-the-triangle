// This class represent a date object
public class Date {

    private int _day;
    private int _month;
    private int _year;
    //Min and max value for each variable
    private static final int DEFAULT_VALUE = 0;
    private static final int DAY_MIN_VALUE = 1;
    private static final int DAY_MAX_VALUE = 31;
    private static final int MONTH_MIN_VALUE = 1;
    private static final int MONTH_MAX_VALUE = 12;
    private static final int YEAR_MIN_VALUE = 1000;
    private static final int YEAR_MAX_VALUE = 9999;
    //A constractor with limitations for the variables: day, month, year
    public Date(int day, int month, int year)
    {
        if((((month == 4 || month == 6 || month == 9 || month == 11) && day >= DAY_MIN_VALUE && day < DAY_MAX_VALUE) || ((month == MONTH_MIN_VALUE || month == 3 ||
                month == 5 || month == 7 || month == 8 || month == 10 || month == MONTH_MAX_VALUE) && day >= DAY_MIN_VALUE && day <= DAY_MAX_VALUE) ||
                (month == 2 && day >= DAY_MIN_VALUE && day <= 28)) && year >= YEAR_MIN_VALUE && year <= YEAR_MAX_VALUE)
        {
            this._day = day;
            this._month = month;
            this._year = year;
        }
        else
        {
            _day = DAY_MIN_VALUE;
            _month = MONTH_MIN_VALUE;
            _year = 2000;
        }
    }
    // A constractor for other Date
    public Date(Date other)
    {
        this._day = other._day;
        this._month = other._month;
        this._year = other._year;
    }
    //Get methods
    public int getDay() {return _day;}
    public int getMonth() {return _month;}
    public int getYear() {return _year;}
    // Set methods
    public void setDay(int dayToSet)
    {
        if(dayToSet >= DAY_MIN_VALUE && dayToSet <= DAY_MAX_VALUE)
            _day = dayToSet;
    }

    public void setMonth(int monthToSet)
    {
        if(monthToSet >= MONTH_MIN_VALUE && monthToSet <= MONTH_MAX_VALUE)
            _month = monthToSet;
    }

    public void setYear(int yearToSet)
    {
        if(yearToSet >= YEAR_MIN_VALUE && yearToSet <= YEAR_MAX_VALUE)
            _year = yearToSet;
    }
    //Check if all variables of this Date are equale to those of Date other
    public boolean equals(Date other)
    {
        return this._day == other._day &&
                this._month == other._month &&
                this._year == other._year;
    }
    //Check if this Date is before Date other
    public boolean before(Date other)
    {
        if(this._year < other._year ||
                this._year == other._year && this._month < other._month ||
                this._year == other._year && this._month == other._month && this._day < other._day)
        {
            boolean result = this.before(other);
            return result;
        }
        return this._year < other._year ||
                this._year == other._year && this._month < other._month ||
                this._year == other._year && this._month == other._month && this._day < other._day;
    }
    //Check if this Date is after Date other
    public boolean after(Date other)
    {
        if(other.before(this))
        {
            boolean result = other.before(this);
            return result;
        }
        return this._year > other._year ||
                this._year == other._year && this._month > other._month ||
                this._year == other._year && this._month == other._month && this._day > other._day;
    }
    //Calculate the diffrence in days between this Date and Date other
    public int difference (Date other)
    {
        if(this._year < other._year && this._month == other._month)
        {
            return 365 * (other._year - this._year) + other._day - this._day;
        }
        if(this._year > other._year && this._month == other._month)
        {
            return 365 * (this._year - other._year) + this._day - other._day;
        }
        if(this._year <= other._year && this._month == 2 && other._month == 3)
        {
            return 365 * (other._year - this._year) + 28 + other._day - this._day;
        }
        if(this._year >= other._year && this._month == 3 && other._month == 2)
        {
            return 365 * (this._year - other._year) + 28 + this._day - other._day;
        }
        if(this._year < other._year && this._month == 3 && other._month == 2)
        {
            return 365 * (other._year - this._year) - 28 + other._day - this._day;
        }
        if(this._year > other._year && this._month == 2 && other._month == 3)
        {
            return 365 * (this._year - other._year) - 28 + this._day - other._day;
        }
        if(this._year <= other._year && ((this._month == 4 && other._month == 5) || (this._month == 6 && other._month == 7) ||
                (this._month == 9 && other._month == 10) || (this._month == 11 && other._month == 12)))
        {
            return 365 * (other._year - this._year) + 30 + other._day - this._day;
        }
        if(this._year >= other._year && ((this._month == 5 && other._month == 4) ||
                (this._month == 7 && other._month == 6) || (this._month == 10 && other._month == 9) || (this._month == 12 && other._month == 11)))
        {
            return 365 * (this._year - other._year) + 30 + this._day - other._day;
        }
        if(this._year < other._year && ((this._month == 5 && other._month == 4) || (this._month == 7 && other._month == 6) ||
                (this._month == 10 && other._month == 9) || (this._month == 12 && other._month == 11)))
        {
            return 365 * (other._year - this._year) - 30 + other._day - this._day;
        }
        if(this._year > other._year && ((this._month == 4 && other._month == 5) || (this._month == 6 && other._month == 7) || (this._month == 9 && other._month == 10) ||
                (this._month == 11 && other._month == 12)))
        {
            return 365 * (this._year - other._year) - 30 + this._day - other._day;
        }
        if(this._year <= other._year && ((this._month == 1 && other._month == 2) || (this._month == 3 && other._month == 4) ||
                (this._month == 7 && other._month == 8) || (this._month == 8 && other._month == 9) || (this._month == 10 && other._month ==11)))
        {
            return 365 * (other._year - this._year) + 31 + other._day - this._day;
        }
        if(this._year >= other._year && ((this._month == 2 && other._month == 1) || (this._month == 4 && other._month == 3) ||
                (this._month == 8 && other._month == 7) || (this._month == 9 && other._month == 8) || (this._month == 11 && other._month == 10)))
        {
            return 365 * (this._year - other._year) + 31 + this._day - other._day;
        }
        if(this._year < other._year && ((this._month == 2 && other._month == 1) || (this._month == 4 && other._month == 3) ||
                (this._month == 8 && other._month == 7) || (this._month == 9 && other._month == 8) || (this._month == 11 && other._month == 10)))
        {
            return 365 * (other._year - this._year) - 31 + other._day - this._day;
        }
        if(this._year > other._year && ((this._month == 1 && other._month == 2) || (this._month == 3 && other._month == 4) ||
                (this._month == 7 && other._month == 8) || (this._month == 8 && other._month == 9) || (this._month == 10 && other._month == 11)))
        {
            return 365 * (this._year - other._year) - 31 + this._day - other._day;
        }
        if(this._year <= other._year && ((this._month == 1 && other._month == 3) || (this._month == 2 && other._month == 4)))
        {
            return 365 * (other._year - this._year) + 59 + other._day - this._day;
        }
        if(this._year >= other._year && ((this._month == 3 && other._month == 1) || (this._month == 4 && other._month == 2)))
        {
            return 365 * (this._year - other._year) + 59 + this._day - other._day;
        }
        if(this._year < other._year && ((this._month == 3 && other._month == 1) || (this._month == 4 && other._month == 2)))
        {
            return 365 * (other._year - this._year) - 59 + other._day - this._day;
        }
        if(this._year > other._year && ((this._month == 1 && other._month == 3) || (this._month == 2 && other._month == 4)))
        {
            return 365 * (this._year - other._year) - 59 + this._day - other._day;
        }
        if(this._year <= other._year && ((this._month == 3 && other._month == 5) || (this._month == 4 && other._month == 6) || (this._month == 5 && other._month == 7) ||
                (this._month == 6 && other._month == 8) || (this._month == 8 && other._month == 10) || (this._month == 9 && other._month == 11) || (this._month == 10 && other._month == 12)))
        {
            return 365 * (other._year - this._year) + 61 + other._day - this._day;
        }
        if(this._year >= other._year && ((this._month == 5 && other._month == 3) || (this._month == 6 && other._month == 4) || (this._month == 7 && other._month == 5) ||
                (this._month == 8 && other._month == 6) || (this._month == 10 && other._month == 8) || (this._month == 11 && other._month == 9) || (this._month == 12 && other._month == 10)))
        {
            return 365 * (this._year - other._year) + 61 + this._day - other._day;
        }
        if(this._year < other._year && ((this._month == 5 && other._month == 3) || (this._month == 6 && other._month == 4) || (this._month == 7 && other._month == 5) ||
                (this._month == 8 && other._month == 6) || (this._month == 10 && other._month == 8) || (this._month == 11 && other._month == 9) || (this._month == 12 && other._month == 10)))
        {
            return 365 * (other._year - this._year) - 61 + other._day - this._day;
        }
        if(this._year > other._year && ((this._month == 3 && other._month == 5) || (this._month == 4 && other._month == 6) || (this._month == 5 && other._month == 7) ||
                (this._month == 6 && other._month == 8) || (this._month == 8 && other._month == 10) || (this._month == 9 && other._month == 11) || (this._month == 10 && other._month == 12)))
        {
            return 365 * (this._year - other._year) - 61 + this._day - other._day;
        }
        if(this._year <= other._year && this._month == 7 && other._month == 9)
        {
            return 365 * (other._year - this._year) + 62 + other._day - this._day;
        }
        if(this._year >= other._year && this._month == 9 && other._month == 7)
        {
            return 365 * (this._year - other._year) + 62 + this._day - other._day;
        }
        if(this._year < other._year && this._month == 9 && other._month == 7)
        {
            return 365 * (other._year - this._year) - 62 + other._day - this._day;
        }
        if(this._year > other._year && this._month == 7 && other._month == 9)
        {
            return 365 * (this._year - other._year) - 62 + this._day - other._day;
        }
        if(this._year <= other._year && this._month == 2 && other._month == 5)
        {
            return 365 * (other._year - this._year) + 89 + other._day - this._day;
        }
        if(this._year >= other._year && this._month == 5 && other._month == 2)
        {
            return 365 * (this._year - other._year) + 89 + this._day - other._day;
        }
        if(this._year < other._year && this._month == 5 && other._month == 2)
        {
            return 365 * (other._year - this._year) - 89 + other._day - this._day;
        }
        if(this._year > other._year && this._month == 2 && other._month == 5)
        {
            return 365 * (this._year - other._year) - 89 + this._day - other._day;
        }
        if(this._year <= other._year && this._month == 1 && other._month == 4)
        {
            return 365 * (other._year - this._year) + 90 + other._day - this._day;
        }
        if(this._year >= other._year && this._month == 4 && other._month == 1)
        {
            return 365 * (this._year - other._year) + 90 + this._day - other._day;
        }
        if(this._year < other._year && this._month == 4 && other._month == 1)
        {
            return 365 * (other._year - this._year) - 90 + other._day - this._day;
        }
        if(this._year > other._year && this._month == 1 && other._month == 4)
        {
            return 365 * (this._year - other._year) - 90 + this._day - other._day;
        }
        if(this._year <= other._year && ((this._month == 4 && other._month == 7) || (this._month == 9 && other._month == 12)))
        {
            return 365 * (other._year - this._year) + 91 + other._day - this._day;
        }
        if(this._year >= other._year && ((this._month == 7 && other._month == 4) || (this._month == 12 && other._month == 9)))
        {
            return 365 * (this._year - other._year) + 91 + this._day - other._day;
        }
        if(this._year < other._year && ((this._month == 7 && other._month == 4) || (this._month == 12 && other._month == 9)))
        {
            return 365 * (other._year - this._year) - 91 + other._day - this._day;
        }
        if(this._year > other._year && ((this._month == 4 && other._month == 7) || (this._month == 9 && other._month == 12)))
        {
            return 365 * (this._year - other._year) - 91 + this._day - other._day;
        }
        if(this._year <= other._year && ((this._month == 3 && other._month == 6) || (this._month == 5 && other._month == 8) || (this._month == 6 && other._month == 9) ||
                (this._month == 7 && other._month == 10) || (this._month == 8 && other._month == 11)))
        {
            return 365 * (other._year - this._year) + 92 + other._day - this._day;
        }
        if(this._year >= other._year && ((this._month == 6 && other._month == 3) || (this._month == 8 && other._month == 5) || (this._month == 9 && other._month == 6) ||
                (this._month == 10 && other._month == 7) || (this._month == 11 && other._month == 8)))
        {
            return 365 * (this._year - other._year) + 92 + this._day - other._day;
        }
        if(this._year < other._year && ((this._month == 6 && other._month == 3) || (this._month == 8 && other._month == 5) || (this._month == 9 && other._month == 6) ||
                (this._month == 10 && other._month == 7) || (this._month == 11 && other._month == 8)))
        {
            return 365 * (other._year - this._year) - 92 + other._day - this._day;
        }
        if(this._year > other._year && ((this._month == 3 && other._month == 6) || (this._month == 5 && other._month == 8) || (this._month == 6 && other._month == 9) ||
                (this._month == 7 && other._month == 10) || (this._month == 8 && other._month == 11)))
        {
            return 365 * (this._year - other._year) - 92 + this._day - other._day;
        }
        if(this._year <= other._year && ((this._month == 1 && other._month == 5) || (this._month == 2 && other._month == 6)))
        {
            return 365 * (other._year - this._year) + 120 + other._day - this._day;
        }
        if(this._year >= other._year && ((this._month == 5 && other._month == 1) || (this._month == 6 && other._month == 2)))
        {
            return 365 * (this._year - other._year) + 120 + this._day - other._day;
        }
        if(this._year < other._year && ((this._month == 5 && other._month == 1) || (this._month == 6 && other._month == 2)))
        {
            return 365 * (other._year - this._year) - 120 + other._day - this._day;
        }
        if(this._year > other._year && ((this._month == 1 && other._month == 5) || (this._month == 2 && other._month == 6)))
        {
            return 365 * (this._year - other._year) - 120 + this._day - other._day;
        }
        if(this._year <= other._year && ((this._month == 3 && other._month == 7) || (this._month == 4 && other._month == 8) || (this._month == 6 && other._month == 10) ||
                (this._month == 8 && other._month == 12)))
        {
            return 365 * (other._year - this._year) + 122 + other._day - this._day;
        }
        if(this._year >= other._year && ((this._month == 7 && other._month == 3) || (this._month == 8 && other._month == 4) || (this._month == 10 && other._month == 6) ||
                (this._month == 12 && other._month == 8)))
        {
            return 365 * (this._year - other._year) + 122 + this._day - other._day;
        }
        if(this._year < other._year && ((this._month == 7 && other._month == 3) || (this._month == 8 && other._month == 4) || (this._month == 10 && other._month == 6) ||
                (this._month == 12 && other._month == 8)))
        {
            return 365 * (other._year - this._year) - 122 + other._day - this._day;
        }
        if(this._year > other._year && ((this._month == 3 && other._month == 7) || (this._month == 4 && other._month == 8) || (this._month == 6 && other._month == 10) ||
                (this._month == 8 && other._month == 12)))
        {
            return 365 * (this._year - other._year) - 122 + this._day - other._day;
        }
        if(this._year <= other._year && ((this._month == 5 && other._month == 9) || (this._month == 7 && other._month == 11)))
        {
            return 365 * (other._year - this._year) + 123 + other._day - this._day;
        }
        if(this._year >= other._year && ((this._month == 9 && other._month == 5) || (this._month == 11 && other._month == 7)))
        {
            return 365 * (this._year - other._year) + 123 + this._day - other._day;
        }
        if(this._year < other._year && ((this._month == 9 && other._month == 5) || (this._month == 11 && other._month == 7)))
        {
            return 365 * (other._year - this._year) - 123 + other._day - this._day;
        }
        if(this._year < other._year && ((this._month == 9 && other._month == 5) || (this._month == 11 && other._month == 7)))
        {
            return 365 * (this._year - other._year) - 123 + this._day - other._day;
        }
        if(this._year <= other._year && this._month == 2 && other._month == 7)
        {
            return 365 * (other._year - this._year) + 150 + other._day - this._day;
        }
        if(this._year >= other._year && this._month == 7 && other._month == 2)
        {
            return 365 * (this._year - other._year) + 150 + this._day - other._day;
        }
        if(this._year < other._year && this._month == 7 && other._month == 2)
        {
            return 365 * (other._year - this._year) - 150 + other._day - this._day;
        }
        if(this._year > other._year && this._month == 2 && other._month == 7)
        {
            return 365 * (this._year - other._year) - 150 + this._day - other._day;
        }
        if(this._year <= other._year && this._month == 1 && other._month == 6)
        {
            return 365 * (other._year - this._year) + 151 + other._day - this._day;
        }
        if(this._year >= other._year && this._month == 6 && other._month == 1)
        {
            return 365 * (this._year - other._year) + 151 + this._day - other._day;
        }
        if(this._year < other._year && this._month == 6 && other._month == 1)
        {
            return 365 * (other._year - this._year) - 151 + other._day - this._day;
        }
        if(this._year > other._year && this._month == 1 && other._month == 6)
        {
            return 365 * (this._year - other._year) - 151 + this._day - other._day;
        }
        if(this._year <= other._year && ((this._month == 3 && other._month == 8) || (this._month == 4 && other._month == 9) || (this._month == 5 && other._month == 10) ||
                (this._month == 6 && other._month == 11) || (this._month == 7 && other._month == 12)))
        {
            return 365 * (other._year - this._year) + 153 + other._day - this._day;
        }
        if(this._year >= other._year && ((this._month == 8 && other._month == 3) || (this._month == 9 && other._month == 4) || (this._month == 10 && other._month == 5) ||
                (this._month == 11 && other._month == 6) || (this._month == 12 && other._month == 7)))
        {
            return 365 * (this._year - other._year) + 153 + this._day - other._day;
        }
        if(this._year < other._year && ((this._month == 8 && other._month == 3) || (this._month == 9 && other._month == 4) || (this._month == 10 && other._month == 5) ||
                (this._month == 11 && other._month == 6) || (this._month == 12 && other._month == 7)))
        {
            return 365 * (other._year - this._year) - 153 + other._day - this._day;
        }
        if(this._year > other._year && ((this._month == 3 && other._month == 8) || (this._month == 4 && other._month == 9) || (this._month == 5 && other._month == 10) ||
                (this._month == 6 && other._month == 11) || (this._month == 7 && other._month == 12)))
        {
            return 365 * (this._year - other._year) - 153 + this._day - other._day;
        }
        if(this._year <= other._year && ((this._month == 1 && other._month == 7) || (this._month == 2 && other._month == 8)))
        {
            return 365 * (other._year - this._year) + 181 + other._day - this._day;
        }
        if(this._year >= other._year && ((this._month == 7 && other._month == 1) || (this._month == 8 && other._month == 2)))
        {
            return 365 * (this._year - other._year) + 181 + this._day - other._day;
        }
        if(this._year < other._year && ((this._month == 7 && other._month == 1) || (this._month == 8 && other._month == 2)))
        {
            return 365 * (other._year - this._year) - 181 + other._day - this._day;
        }
        if(this._year > other._year && ((this._month == 1 && other._month == 7) || (this._month == 2 && other._month == 8)))
        {
            return 365 * (this._year - other._year) - 181 + this._day - other._day;
        }
        if(this._year <= other._year && ((this._month == 4 && other._month == 10) || (this._month == 6 && other._month == 12)))
        {
            return 365 * (other._year - this._year) + 183 + other._day - this._day;
        }
        if(this._year >= other._year && ((this._month == 10 && other._month == 4) || (this._month == 12 && other._month == 6)))
        {
            return 365 * (this._year - other._year) + 183 + this._day - other._day;
        }
        if(this._year < other._year && ((this._month == 10 && other._month == 4) || (this._month == 12 && other._month == 6)))
        {
            return 365 * (other._year - this._year) - 183 + other._day - this._day;
        }
        if(this._year > other._year && ((this._month == 4 && other._month == 10) || (this._month == 6 && other._month == 12)))
        {
            return 365 * (this._year - other._year) - 183 + this._day - other._day;
        }
        if(this._year <= other._year && ((this._month == 3 && other._month == 9) || (this._month == 5 && other._month == 11)))
        {
            return 365 * (other._year - this._year) + 184 + other._day - this._day;
        }
        if(this._year >= other._year && ((this._month == 9 && other._month == 3) || (this._month == 11 && other._month == 5)))
        {
            return 365 * (this._year - other._year) + 184 + this._day - other._day;
        }
        if(this._year < other._year && ((this._month == 9 && other._month == 3) || (this._month == 11 && other._month == 5)))
        {
            return 365 * (other._year - this._year) - 184 + other._day - this._day;
        }
        if(this._year > other._year && ((this._month == 3 && other._month == 9) || (this._month == 5 && other._month == 11)))
        {
            return 365 * (this._year - other._year) - 184 + this._day - other._day;
        }
        if(this._year <= other._year && ((this._month == 1 && other._month == 8) || (this._month == 2 && other._month == 9)))
        {
            return 365 * (other._year - this._year) + 212 + other._day - this._day;
        }
        if(this._year >= other._year && ((this._month == 8 && other._month == 1) || (this._month == 9 && other._month == 2)))
        {
            return 365 * (this._year - other._year) + 212 + this._day - other._day;
        }
        if(this._year < other._year && ((this._month == 8 && other._month == 1) || (this._month == 9 && other._month == 2)))
        {
            return 365 * (other._year - this._year) - 212 + other._day - this._day;
        }
        if(this._year > other._year && ((this._month == 1 && other._month == 8) || (this._month == 2 && other._month == 9)))
        {
            return 365 * (this._year - other._year) - 212 + this._day - other._day;
        }
        if(this._year <= other._year && ((this._month == 3 && other._month == 10) || (this._month == 4 && other._month == 11) || (this._month == 5 && other._month == 12)))
        {
            return 365 * (other._year - this._year) + 214 + other._day - this._day;
        }
        if(this._year >= other._year && ((this._month == 10 && other._month == 3) || (this._month == 11 && other._month == 4) || (this._month == 12 && other._month == 5)))
        {
            return 365 * (this._year - other._year) + 214 + this._day - other._day;
        }
        if(this._year < other._year && ((this._month == 10 && other._month == 3) || (this._month == 11 && other._month == 4) || (this._month == 12 && other._month == 5)))
        {
            return 365 * (other._year - this._year) - 214 + other._day - this._day;
        }
        if(this._year > other._year && ((this._month == 3 && other._month == 10) || (this._month == 4 && other._month == 11) || (this._month == 5 && other._month == 12)))
        {
            return 365 * (this._year - other._year) - 214 + this._day - other._day;
        }
        if(this._year <= other._year && this._month == 2 && other._month == 10)
        {
            return 365 * (other._year - this._year) + 242 + other._day - this._day;
        }
        if(this._year >= other._year && this._month == 10 && other._month == 2)
        {
            return 365 * (this._year - other._year) + 242 + this._day - other._day;
        }
        if(this._year < other._year && this._month == 10 && other._month == 2)
        {
            return 365 * (other._year - this._year) - 242 + other._day - this._day;
        }
        if(this._year > other._year && this._month == 2 && other._month == 10)
        {
            return 365 * (this._year - other._year) - 242 + this._day - other._day;
        }
        if(this._year <= other._year && this._month == 1 && other._month == 9)
        {
            return 365 * (other._year - this._year) + 243 + other._day - this._day;
        }
        if(this._year >= other._year && this._month == 9 && other._month == 1)
        {
            return 365 * (this._year - other._year) + 243 + this._day - other._day;
        }
        if(this._year < other._year && this._month == 9 && other._month == 1)
        {
            return 365 * (other._year - this._year) - 243 + other._day - this._day;
        }
        if(this._year > other._year && this._month == 1 && other._month == 9)
        {
            return 365 * (this._year - other._year) - 243 + this._day - other._day;
        }
        if(this._year <= other._year && this._month == 4 && other._month == 12)
        {
            return 365 * (other._year - this._year) + 244 + other._day - this._day;
        }
        if(this._year >= other._year && this._month == 12 && other._month == 4)
        {
            return 365 * (this._year - other._year) + 244 + this._day - other._day;
        }
        if(this._year < other._year && this._month == 12 && other._month == 4)
        {
            return 365 * (other._year - this._year) - 244 + other._day - this._day;
        }
        if(this._year > other._year && this._month == 4 && other._month == 12)
        {
            return 365 * (this._year - other._year) - 244 + this._day - other._day;
        }
        if(this._year <= other._year && this._month == 3 && other._month == 11)
        {
            return 365 * (other._year - this._year) + 245 + other._day - this._day;
        }
        if(this._year >= other._year && this._month == 11 && other._month == 3)
        {
            return 365 * (this._year - other._year) + 245 + this._day - other._day;
        }
        if(this._year < other._year && this._month == 11 && other._month == 3)
        {
            return 365 * (other._year - this._year) - 245 + other._day - this._day;
        }
        if(this._year > other._year && this._month == 3 && other._month == 11)
        {
            return 365 * (this._year - other._year) - 245 + this._day - other._day;
        }
        if(this._year <= other._year && this._month == 1 && other._month == 10)
        {
            return 365 * (other._year - this._year) + 273 + other._day - this._day;
        }
        if(this._year >= other._year && this._month == 10 && other._month == 1)
        {
            return 365 * (this._year - other._year) + 273 + this._day - other._day;
        }
        if(this._year < other._year && this._month == 10 && other._month == 1)
        {
            return 365 * (other._year - this._year) - 273 + other._day - this._day;
        }
        if(this._year > other._year && this._month == 1 && other._month == 10)
        {
            return 365 * (this._year - other._year) - 273 + this._day - other._day;
        }
        if(this._year <= other._year && this._month == 2 && other._month == 11)
        {
            return 365 * (other._year - this._year) + 274 + other._day - this._day;
        }
        if(this._year >= other._year && this._month == 11 && other._month == 2)
        {
            return 365 * (this._year - other._year) + 274 + this._day - other._day;
        }
        if(this._year < other._year && this._month == 11 && other._month == 2)
        {
            return 365 * (other._year - this._year) - 274 + other._day - this._day;
        }
        if(this._year > other._year && this._month == 2 && other._month == 11)
        {
            return 365 * (this._year - other._year) - 274 + this._day - other._day;
        }
        if(this._year <= other._year && this._month == 3 && other._month == 12)
        {
            return 365 * (other._year - this._year) + 275 + other._day - this._day;
        }
        if(this._year >= other._year && this._month == 12 && other._month == 3)
        {
            return 365 * (this._year - other._year) + 275 + this._day - other._day;
        }
        if(this._year < other._year && this._month == 12 && other._month == 3)
        {
            return 365 * (other._year - this._year) - 275 + other._day - this._day;
        }
        if(this._year > other._year && this._month == 3 && other._month == 12)
        {
            return 365 * (this._year - other._year) - 275 + this._day - other._day;
        }
        if(this._year <= other._year && ((this._month == 1 && other._month == 11) || (this._month == 2 && other._month == 12)))
        {
            return 365 * (other._year - this._year) + 304 + other._day - this._day;
        }
        if(this._year >= other._year && ((this._month == 11 && other._month == 1) || (this._month == 12 && other._month == 2)))
        {
            return 365 * (this._year - other._year) + 304 + this._day - other._day;
        }
        if(this._year < other._year && ((this._month == 11 && other._month == 1) || (this._month == 12 && other._month == 2)))
        {
            return 365 * (other._year - this._year) - 304 + other._day - this._day;
        }
        if(this._year > other._year && ((this._month == 1 && other._month == 11) || (this._month == 2 && other._month == 12)))
        {
            return 365 * (this._year - other._year) - 304 + this._day - other._day;
        }
        if(this._year <= other._year && this._month == 1 && other._month == 12)
        {
            return 365 * (other._year - this._year) + 334 + other._day - this._day;
        }
        if(this._year >= other._year && this._month == 12 && other._month == 1)
        {
            return 365 * (this._year - other._year) + 334 + this._day - other._day;
        }
        if(this._year < other._year && this._month == 12 && other._month == 1)
        {
            return 365 * (other._year - this._year) - 334 + other._day - this._day;
        }
        if(this._year > other._year && this._month == 1 && other._month == 12)
        {
            return 365 * (this._year - other._year) - 334 + this._day - other._day;
        }
        else
        {
            return Math.abs(this._day - other._day);
        }
    }
    //String of Date (day/month/year)
    public String toString()
    {
        String result = "" + _day + "/" + _month + "/" + _year + "";
        if(_day >= DAY_MIN_VALUE && _day <= 9 && _month >= 10 && _month <= MONTH_MAX_VALUE)
        {
            return "" + 0 + "" + _day + "/" + _month + "/" + _year + "";
        }
        if(_month >= MONTH_MIN_VALUE && _month <= 9 && _day >= 10 && _day <= DAY_MAX_VALUE)
        {
            return "" + _day + "/" + 0 + "" + _month + "/" + _year + "";
        }
        if(_day >= DAY_MIN_VALUE && _day <= 9 && _month >= MONTH_MIN_VALUE && _month <= 9)
        {
            return "" + 0 + "" + _day + "/" + 0 + "" + _month + "/" + _year + "";
        }
        else
        {
            return result;
        }
    }
    // Find the day of tomorrow
    public Date tomorrow()
    {
        if(_day == DAY_MAX_VALUE && _month == MONTH_MAX_VALUE)
        {
            int DatetomorrowDay = DAY_MIN_VALUE;
            int DatetomorrowMonth = MONTH_MIN_VALUE;
            int DatetomorrowYear = this._year + 1;
            return new Date(DatetomorrowDay,DatetomorrowMonth,DatetomorrowYear);
        }
        if(((_month == 4 || _month == 6 || _month == 9 || _month == 11) && _day == 30) ||
                ((_month == MONTH_MIN_VALUE || _month == 3 || _month == 7 || _month == 8 && _month == 10)
                        && _day == DAY_MAX_VALUE) || (_month == 2 && _day == 28))
        {
            int DatetomorrowDay = DAY_MIN_VALUE;
            int DatetomorrowMonth = this._month + 1;
            int DatetomorrowYear = this._year;
            return new Date(DatetomorrowDay,DatetomorrowMonth,DatetomorrowYear);
        }
        else
        {
            int DatetomorrowDay = this._day + 1;
            int DatetomorrowMonth = this._month;
            int DatetomorrowYear = this._year;
            return new Date(DatetomorrowDay,DatetomorrowMonth,DatetomorrowYear);
        }
    }
}