import java.util.Scanner;
public class Train {
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        // Read the speed (in km/h), time (in minutes) of train 1
        System.out.println("Please enter 4 integers");
        System.out.println("Please enter the speed of train 1:");
        int v1 = scan.nextInt();
        System.out.println("Please enter the time of train 1:");
        int t1 = scan.nextInt();
        // Read the speed (in km/h), time (in minutes) of train 2
        System.out.println("Please enter the speed of train 2:");
        int v2 = scan.nextInt();
        System.out.println("Please enter the time of train 2:");
        int t2 = scan.nextInt();
        // Calculate the distance that each train has passed
        double d1 = v1 * t1;
        double d2 = v2 * t2;
        double D1 = d1/60;
        double D2 = d2/60;
        // Calculate the distance between the trains
        double D = Math.abs(D1-D2);
        System.out.println("The distance between the trains is" + (D) + "km");


    }
}
