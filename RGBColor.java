public class RGBColor {

    private int _red;
    private int _green;
    private int _blue;

    private static final int DEFAULT_VALUE = 0;
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 255;
    private static final double RED_FAST_IN_GRAYSCALE = 0.3;
    private static final double GREEN_FAST_IN_GRAYSCALE = 0.59;
    private static final double BLUE_FAST_IN_GRAYSCALE = 0.11;


    public RGBColor()
    {
        _red = _green = _blue = DEFAULT_VALUE;
    }

    public RGBColor(int red, int green, int blue)
    {
        if(red <= MIN_VALUE || red > MAX_VALUE || green <= MIN_VALUE || green > MAX_VALUE || blue <= MIN_VALUE || blue > MAX_VALUE)
        {
            _red = _green = _blue = DEFAULT_VALUE;
        }
        else
        {
            this._red = red;
            this._green = green;
            this._blue = blue;
        }
    }

    public RGBColor(RGBColor other)
    {
        this._red = other._red;
        this._green = other._green;
        this._blue = other._blue;
    }

    public int getRed() {return _red;}
    public int getGreen() {return _green;}
    public int getBlue() {return _blue;}

    public void setRed(int num)
    {
        if(num >= MIN_VALUE && num <= MAX_VALUE)
            _red = num;
    }

    public void setGreen(int num)
    {
        if(num >= MIN_VALUE && num <= MAX_VALUE)
            _green = num;
    }

    public void setBlue(int num)
    {
        if(num >= MIN_VALUE && num <= MAX_VALUE)
            _blue = num;
    }

    public String toString()
    {
        String result = "(" + _red + "," + _green + "," + _blue + ")";
        return result;
    }

    public boolean equales(RGBColor other)
    {
        return this._red == other._red &&
                this._green == other._green &&
                this._blue == other._blue;
    }

    public void mix(RGBColor other)
    {
        _red = (_red + other._red) / 2;
        _green = (_green + other._green) / 2;
        _blue = (_blue + other._blue) / 2;
    }

    public double consertToGrayscale()
    {
        return 0.3 * _red + 0.59 * _green + 0.11 * _blue;
    }
}
