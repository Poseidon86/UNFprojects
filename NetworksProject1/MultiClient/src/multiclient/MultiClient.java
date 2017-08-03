
package multiclient;

import java.io.BufferedReader;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * This class prompts menu for client requests 
 * @author Christian and Brian
 */
public class MultiClient {

    
     public static String userInput;
     public static int times, option;
  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       
    String hostName = args[0];
    int portNumber = Integer.parseInt(args[1]);
    
    
    
        if (args.length != 2){
            System.err.println("Usage: java Client <host name> <port number>");
            System.exit(1);
        }//end if
      


        try{         
            Socket clientSocket = new Socket(hostName, portNumber);
      
            
    while(true){  
           
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        Scanner s = new Scanner(System.in);

   
      long start_time = System.currentTimeMillis(); 
      
     
             
        System.out.println( "1) Server Current Date and Time\n"
                +           "2) Server number of running processes\n"
                +           "3) Server number of socket connections\n"
                +           "4) Server time of last system boot\n"
                +           "5) Server current users\n"
                +           "6) Server echo back what is sent from client\n"
                +           "7) Quit\n" );
        
        System.out.println("Select your option: ");
            option = stdIn.read();
            
        System.out.println("How many times would you like to execute this command?");
            times = s.nextInt();

         
        for(int i=0; i<times; i++){   
            
     switch (option) {
      case '1':       
            out.println("MC:1");
            System.out.println(in.readLine());
          
        break;
      case '2':
            out.println("MC:2");  
            System.out.println(in.readLine());
        break;
      case '3':
            out.println("MC:3");
            System.out.println(in.readLine());
        break;
      case '4':
            out.println("MC:4");
            System.out.println(in.readLine());
        break;
      case '5':
            out.println("MC:5");
            System.out.println(in.readLine());
        break;
      case '6':
         Scanner name = new Scanner(System.in);
         System.out.println("Enter text: ");

          for(int j=0; j<times; j++){
          String d =  name.next();       
             out.println("MC:6");        
               out.println(d);
            System.out.print(in.readLine());
          }
        break;
      
      case '7':
            out.println("MC:7");
            System.out.println(in.readLine());
            return;
      default:
            System.err.println ( "Unrecognized option" );
           continue;
       
       
       
    } //end switch
     
     System.out.println("\nRequest " + (i+1) + " is done\n");
      
    while ((userInput = in.readLine()) != null && !userInput.equalsIgnoreCase("ServerDone"))       
            out.println(userInput);      
    
        } //end for loop       
        

    long end_time = System.currentTimeMillis();
    

    
//Print length of time and status of option
      System.out.println("--" + "This command took " + (end_time-start_time) + "ms");	
      System.out.println("Option " + option + " is complete");
 
      }// end while loop
        }//end try
    
   
    
   catch(NumberFormatException e){
                   
        System.out.print("Please enter valid option!!\n");
            System.exit(1); 
       }//end catch
 
        
   catch (UnknownHostException e){
                System.err.println("Don't know host " + hostName);
                System.exit(1);              
                }//end catch
        
   catch (IOException e){
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);         
        } //end catch
   catch (InputMismatchException e){
         System.err.println ( "Unrecognized input "  + e);
      
   }//end catch
      
         
       
    }//end main
}//end class MultiClient

    
    




    
     