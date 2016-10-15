/*
* Author: Christian Wilson
* Course: COP2551
* Homework #: 5
* Title : Determines amount of prime numbers
* Due Date: 3/6/2016
*
* Determines amount of prime numbers between 0 and value entered. */
package homework5;

import java.util.Scanner;

public class Homework5 {
    
/**
*
*Determines amount of prime numbers between 0 and value entered.
*/
    public static int COUNTER = 0;
    
    public static void main(String[] args) {
        
        //Displays user name and assignment
        System.out.format("Christian Wilson%nHomework 5%n");
        
        //Initializing program
        Scanner input = new Scanner(System.in); 
        int value, min = 0, max = 1000;
        
        
        //Get user input
        System.out.format("%nEnter a number between 0 and 1000: ");
        value = input.nextInt(); 
        
        //Determine is input is within range and counts total prime numbers between 0 and value entered
         if(withinRange(value, min, max)){
       isPrime(value);
           countPrimes(value);
      System.out.format("Exactly " + COUNTER + " prime numbers exist between 0 and " + value);
           System.out.format("%n");
        }
        }
               
/**
 * Counts the number of primes that exist between 0 and entered value
 * @param input
 * @return number of primes
 */
        
        
           public static int countPrimes(int input) {
            int number = 0;
            do{ 
                if (isPrime(number)){
                    COUNTER++; number++;
                }
                else number++;
            }
            while (number <= input);
        
            return number;
    }
           
/**
 * Testing to see if number is prime
 * @param testValue 
 * @return prime number
 */           
    
    public static boolean isPrime(int testValue) {
                boolean isPrime = true;
            if (testValue <= 1) {
               isPrime = false;
       }
       for (int i = 2; i <= Math.sqrt(testValue); i++) {
           if (testValue % i == 0) {
              isPrime = false;
           }
       }
       return isPrime;
   }    
/**
 * Determines if entered value is within specified range
 * @param value The entered value
 * @param min The minimum allowable range
 * @param max The maximum allowable range
 * @return is withinRange(true) or not in range(false) 
 */    
    public static boolean withinRange(int value, int min, int max) {
            boolean withinRange = true;
            if  ((value < min) || (value > max)){
                System.err.format("Input not in range%n");
                withinRange = false;
            }
             return withinRange;
    }          

}
