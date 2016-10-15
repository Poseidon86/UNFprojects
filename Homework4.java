/*
* 
* Title : Determines Leap Year
* Due Date: 2/14/2016
*
* Determines if year between 1900 and 2030 is a leap year or not. */
package homework4;

import java.util.Scanner;

/**
* Determines if year between 1900 and 2030 is a leap year or not. */

public class Homework4 {

  
 
    public static void main(String[] args) 
    {
       //Displays user name and assignment
        System.out.format("Homework 4%n");
        
       //Initilizing program
        Scanner input = new Scanner(System.in);
        int year;
        int min = 1900;
        int max = 2030;
        
       //Get User input
         System.out.format("%nEnter a year between 1900 and 2030: ");
         year = input.nextInt();
        
       //Verify user input and determines if leap year or not 
       if (withinRange(year, min, max))
           if (((year % 400) == 0) || ((year % 4) == 0 && (year % 100) != 0))
             System.out.format(year + " is a leap year.%n");
          else
               System.out.format(year+" is not a leap year.%n");
       }

         
         
/**
* Determines if year is within range
* @param year The year entered. 
* @param min The minimum range. 
* @param max The maximum range.
* @return is within range (true) or not in range (false).
* 
*/
      
    
           public static boolean withinRange(int year,int min,int max){

            if ((year >= min) && (year <= max)){
                return true;
            }
            else if ((year < min) || (year > max)){
                System.err.format("Year not in range%n");
            }
               return false;
                       }
}
            
                
            
           
            

           
           

        


              
             

 
           
             
           


           


           
