/*
* Author: Christian Wilson
* Course: COP2551
* Project #: 2
* Title : Modularized Unit Conversion Tool
* Due Date: 2/21/2016
*
* Converts temperature, distance, and weight. */
package modularized.unit.conversion.tool;

import java.util.Scanner;

/**
* Converts temperature, distance, and weight. */

    public class ModularizedUnitConversionTool {
    
        public static final int MIN = 0;
        public static final int MAX = 100;
        public static final int MAX_2 = 212;
        
        public static int fahrenheit, feet, pounds;
        public static double celsius, meters, kilograms, kelvin, inches, stones;
        public static Scanner input;
        
      
        
    public static void main(String[] args) {
        
        
        //Displays user name and project type       
        System.out.format("Christian Wilson%nProject 2 - Modularized Unit Conversion Tool%n");
       
        //Initializing program
        input = new Scanner(System.in);
        
        if (getInput()) { //Only continue if input is within range
            performConversions(fahrenheit, feet, pounds);
            displayReport(fahrenheit, feet, pounds, celsius, meters, kilograms, kelvin, inches, stones);
        }
     }      
/**
* Determines if input is valid and within range
* @while loop if the input is not valid
* @try this section of code makes sure input is numeric
* @catch this catches any non numeric values and loops back 
* @return is valid and within range (true) or not in range (false)
*/
    
        public static boolean getInput(){ 
            boolean validInput = false;
           
      while(!validInput){
        try{   
           
            System.out.format("%nEnter fahrenheit temperature [0 - 212]: ");     
            fahrenheit = input.nextInt();
            
        
            System.out.format("Enter distance in feet [0 - 100]: ");
            feet = input.nextInt();
        
            System.out.format("Enter weight in pounds [0 - 100]: ");
            pounds = input.nextInt();
           validInput = withinRange(MIN, MAX, MAX_2);
        }
      
        catch(Exception e){
            System.err.format("The entered value is invalid.%n");
            input.next();
    }
       
    
        }
        return validInput;
        }
        
/**
* Determines if number entered is within range
* @param min The minimum allowable range. 
* @param max The maximum allowable range. 
* @param max_2 The second maximum allowable range.
* @return is within range (true) or not in range (false).
* 
*/
public static boolean withinRange(int min, int max, int max_2){
          boolean withinRange = true;
    
          if ((fahrenheit < min) || (fahrenheit > max_2)){
               withinRange = false;
              System.err.format("%nTemperature must be within proper range!!!%n");
    }
                if ((feet < min) || (feet > max)){
                    withinRange = false;
                    System.err.format("%nDistance must be within proper range!!!%n");
    }
                        if ((pounds < min) || (pounds > max)){
                            withinRange = false;
                             System.err.format("%nWeight must be within proper range!!!%n");
     }
                return withinRange;
    
}   

    
/**
* Performs calculated conversions
* @param fahrenheit The temperature entered. 
* @param feet The distance entered. 
* @param pounds The weight entered. 
*/
     
    public static void performConversions(int fahrenheit, int feet, int pounds){
        
        convertTemperature(fahrenheit);
        convertDistance(feet);
        convertWeight(pounds);
        
         
        
        
    }
/**
* Displays calculated conversions
* @param fahrenheit The temperature entered. 
* @param feet The distance entered. 
* @param pounds The weight entered. 
* @param celsius The temperature returned.
* @param kelvin The temperature returned.
* @param meters The distance returned.
* @param inches The distance returned.
* @param kilograms The weight returned.
* @param stones The weight returned.
*/ 
    public static void displayReport(int fahrenheit, int feet, int pounds, double celsius, double meters, double kilograms, double kelvin,
     double inches, double stones){
        
        System.out.format("%n" + fahrenheit+"\u00b0 Fahrenheit is "+ celsius + "\u00b0 Celsius and "+kelvin +"\u00b0 Kelvin%n");
        System.out.format(feet + " Feet is " + meters + " Meters and "+inches +" Inches%n");
        System.out.format(pounds + " Pounds is " + kilograms + " Kilograms and "+ stones +" Stones%n");
            
      }

/**
 * Converts feet to meters and inches
 * @param feet The distance entered
 */
    public static void convertDistance(int feet){
             meters = feet * 0.3048;
             inches = feet * 12;
    }
/**
 * Converts fahrenheit to celsius and kelvin
 * @param fahrenheit The temperature entered
 */    
    public static void convertTemperature(int fahrenheit){
             celsius = ((fahrenheit - 32) * 5/9);
             kelvin = ((fahrenheit + 459.67) * 5/9);
    }
/**
 * Converts pounds to kilograms and stones
 * @param pounds The weight entered
 */
    public static void convertWeight(int pounds){
            kilograms = pounds * 0.4536;
            stones = pounds * 0.0714285714;
           
    }
    
    
} 
    

  
    

   












