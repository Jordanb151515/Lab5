import java.util.Scanner;

/**
 * This program will take input from user by number of seconds and then create a chart for falling distance at each second until the inputed second. Part of Lab 5.
 *
 * @author Jordan Byrne
 * @version v1.0
 * @since 3/13/25
 */
public class FallingDistance{ 
    public static final double ACCELERATION = 9.8;
    public static void main (String[] args) {
        double distance;
        int seconds;

        //collet user input
        Scanner keyboard = new Scanner(System.in);
        System.out.print("How many seconds would you like to compute? ");
        seconds = keyboard.nextInt();

        //set up table
        System.out.println("\nTime(secs)\tDistance(m)");
        System.out.println("================================");

        //loop completes table
        for(int i=1; i<=seconds; i++){
            distance = getDistance(i);
            System.out.printf("%d s\t\t%.1f m\n",i,distance);
        }
    } //end main
    /**
     * getDistance computes the distance fallen after the amount of seconds inputed
     * @param inSeconds input of amount of seconds to compute
     * @return returns the double distance after that period of time
     */
    public static double getDistance(int inSeconds){
        double inDistance;
        inDistance = 0.5 * ACCELERATION * Math.pow(inSeconds,2);
        return inDistance;
    }//end method
}//end class
