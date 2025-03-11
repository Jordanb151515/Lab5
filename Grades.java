import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*; //using multiple classes from java.io

/**
 * Program Description
 * 1) Reads grades from file and writes output to different file containing letter amount, min, max, and average. Part of Lab 5.
 *
 * @author Jordan Byrne
 * @version v1.0
 * @since 3/11/25
 */

public class Grades{ 
    public static void main (String[] args) throws IOException{ 
        String inFile, outFile;
        
        //use methods to complete main and keep it small
        inFile = getInFile();
        outFile = getOutFile();
        processFile(inFile, outFile);
        System.exit(0);

    }//end main

    /**
     * Uses JOptionPane to get and return input file name
     * @return name of file from JOptionPane 
     */
    public static String getInFile() throws IOException{ 
        String temp;
        temp = JOptionPane.showInputDialog("Enter the name of the input file: ");
        
        //make sure the file exists
        File test;
        test = new File(temp);
        while(!test.exists()){
            temp = JOptionPane.showInputDialog("Enter a valid input file name: ");
            test = new File(temp);
        }
        return temp;
    }//end getInFile()

    /**
     * Uses JOptionPane to get and return file name to write output
     * @return name of output file
     */
    private static String getOutFile(){
        String temp;
        temp = JOptionPane.showInputDialog("Enter the name of the output file: ");
        return temp;
    }//end getOutFile()

    /**
     * Calculate the number of each letter grades from each line of file. Calulates min, max, and average from each line and write to output file.
     * Displays to user that calculations are complete.
     * @param inInFile the input file where grades are being retrieved from
     * @param inOutFile the output file that is being created and written to
     */
    public static void processFile(String inInFile, String inOutFile)throws IOException{
        int number;
        int As,Bs,Cs,Ds,Fs,min,max;
        int total,count;
        double avg;
        int set = 1;

        //create objects to scan input file and write to output file
        File inFileName = new File (inInFile);
        Scanner input = new Scanner (inFileName);
        PrintWriter output = new PrintWriter(inOutFile);
      
        //reads input file
        while(input.hasNextLine()){
            As=Bs=Cs=Ds=Fs=count=0;
            avg = 0.0;
            number = input.nextInt();
            min=max=number;
            total=count=0;
            
            //reads individual lines
            while(number != -1){
                if(number<min)
                    min = number;
                if(number>max)
                    max = number;
                count++;
                total += number;

                if(number>=90)
                    As++;
                else if(number>=80)
                    Bs++;
                else if(number>=70)
                    Cs++;
                else if(number>=60)
                    Ds++;
                else
                    Fs++;
                number = input.nextInt();
            }
            
            output.println("Set " + set + " of grades calculated");
            set++;
            if (count == 0)
            output.println("There are no grades to calculate average.\n");
            
            else{
            output.println("Number of As: " + As);
            output.println("Number of Bs: " + Bs);
            output.println("Number of Cs: " + Cs);
            output.println("Number of Ds: " + Ds);
            output.println("Number of Fs: " + Fs);
            output.println("The highest score was: " + max);
            output.println("The lowest score was: " + min);
            avg = (double)total/count;
            output.printf("The average score was: %.1f\n\n", avg);
            }//end else
        }//end while
        //display message to console
        System.out.println("The processing of grades is complete.");
        System.out.println("Output file can be retrieved at, " + inOutFile);
        input.close();
        output.close();
    }//end processFile()
}//end class




