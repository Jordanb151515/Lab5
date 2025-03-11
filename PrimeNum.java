import java.util.Scanner;

/**
 * Program has user enter a number to be tested for Prime. Part of Lab 5.
 *
 * @author Jordan Byrne
 * @version v1.0
 * @since 3/11/25
 */
public class PrimeNum
{
    public static void main(String []args){
        int number;
        boolean isPrime;
        String playAgain;
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a whole number greater then 2 to be tested for prime: ");
        number = keyboard.nextInt();
        
        isPrime = testForPrime(number);
        if(isPrime)
        System.out.println("The number entered is prime.");
        else
        System.out.println("The number entered is not prime.");
        //display play again
        System.out.print("Enter yes if you would like to enter another number: ");
        playAgain = keyboard.next();
        //do-while playAgain.equalsIgnoreCase yes
    }
    /**
     * description
     */
    public static boolean testForPrime(int inNumber){
     int inNumberSqRt;
     inNumberSqRt = (int)Math.sqrt(inNumber);
     boolean isPrimeMeth = true; 
     
     for(int i=2; isPrimeMeth && i<=inNumberSqRt; i++){
      if(inNumber%i == 0)
      isPrimeMeth = false;
    }
    return isPrimeMeth;
    }
    //int inNumberSqRt
    //inNumberSqRt = (int)Math.sqrt(inNumber)
}
