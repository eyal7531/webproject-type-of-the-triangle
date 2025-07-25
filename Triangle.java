import java.util.Scanner;
public class Triangle  {
    public static void main(String [] args) {
        // Read the numbers of the length of the sides of the triangle
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter 3 real numbers as sides of the triangle");
        System.out.println("Please enter x");
        int x = scan.nextInt();
        System.out.println("Please enter y");
        int y = scan.nextInt();
        System.out.println("Please enter z");
        int z = scan.nextInt();
        // Calculate the squared length of each side of the triangle
        double d1 = Math.pow(x,2);
        double d2 = Math.pow(y,2);
        double d3 = Math.pow(z,2);
        // Law of cosines: d3 = d1 + d2 - 2*d1*d2*cosa(a: the angle between x and y) 
        double cosa = ((d1+d2)-d3)/(2*x*y);
        // Check if the numbers represent a triangle. If they do, check the type of the triangle
        // If law of cosines is correct for x,y,z, it means x,y,z represent a triangle 
        // If cosa>-1 && cosa<1 , it means that law of cosines is correct for x,y,z
        // If cosa<=-1 || cosa>=1 , it means that law of cosines isn't correct for x,y,z
        // In a triangle, all sides must be bigger than 0
        if(((x<=0 || y<=0 || z<=0) || ((x>0 && y>0 && z>0) && (cosa<=-1  || cosa>=1))))
            System.out.println("The numbers "+x+","+y+" and "+z+" cannot represent a triangle");
        // If x=y=z, x,y,z must represent a triangle, because in this case: cosa=0.5
        if((x>0 && y>0 && z>0) & (x == y && y == z))
            System.out.println("The numbers "+x+","+y+" and "+z+" represent an equilateral triangle");
        // If cosa=0, x,y,z represent a right angle triangle
        // It can't be an isosceles and a right angle triangle in the same time because x,y,z are integers
        // The ratio between the hypotenuse and the leg in a right angle triangle is Math.sqrt(2)
        if((x>0 && y>0 && z>0) && (cosa>-1 && cosa<1) && ((x == y && x != z) || (x == z && x != y) ||
                (y == z & y != x )))
            System.out.println("The numbers "+x+","+y+" and "+z+" represent an isosceles triangle");
        // If pythagorean Theorem is correct for x,y,z : x,y,z must represent a triangle, because: 0<a<=90 , so 0<=cosa<1
        if((x>0 && y>0 && z>0) && (( d1 == (d2+d3)) || (d2 == (d1+d3)) || (d3 == (d1+d2))))
            System.out.println("The numbers "+x+","+y+" and "+z+" represent a right angle triangle");
        if((x>0 && y>0 && z>0) && (x != y && x != z && y != z) & (cosa>-1 && cosa!=0 && cosa<1) & (d1 != (d2+d3)) &&
                (d2 != (d1+d3)) && (d3 != (d1+d2)))
            System.out.println("The numbers "+x+","+y+" and "+z+" represent a common triangle");
    }
}  