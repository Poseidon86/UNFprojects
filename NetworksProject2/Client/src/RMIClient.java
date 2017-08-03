/* This program implements an the client side of a client-server 
 * application using RPC/RMI. The client connects to the server at the IP address
 * and port provided on then it passes data to the server and waits 
 * for the response from the server.  
 */

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class RMIClient {
    
  private static String userInput, option;
  private static int times;
     
    public static void main(String[] args) {
        
        if (args.length < 2){
            System.err.println("Usage: java RMIClient <host name> <port number>");
          return;
    }


    try{
            Registry reg = LocateRegistry.getRegistry(args[0], Integer.parseInt(args[1]));
            RMI rmi = (RMI) reg.lookup("server");
            
            System.out.println("Connected to Server\n");
            
            
    while(true){
              
     
           Scanner s = new Scanner(System.in);
           userInput = "";
          long start_time;
          long end_time;
      System.out.println( "\n1) Server Current Date and Time\n"
                +           "2) Server number of running processes\n"
                +           "3) Server number of socket connections\n"
                +           "4) Server time of last system boot\n"
                +           "5) Server current users\n"
                +           "6) Server echo back what is sent from client\n"
                +           "7) Quit\n" );
        
          
        System.out.println("Select your option: ");
              option = s.next();
          
  
                  
       if(option.equalsIgnoreCase("7")){
        userInput = rmi.quitProgram();
        System.out.println("Exiting...");
           return;
       } 
  
       else if(Integer.parseInt(option) < 1 || Integer.parseInt(option) > 7 ){
           System.err.println("Must be between 1-7. Try again!!!");
           continue;
       }
       
    try{
        Integer.parseInt(option);
        }
    catch(Exception e){
        System.err.println("Please select a vaild option!!!\n");
    continue;
    }
       

       
    
      System.out.println("How many times would you like to execute this command?");
           times = s.nextInt();
        String times_a = Integer.toString(times);
     try{         
        Integer.parseInt(times_a);
        }
    catch(Exception e){
        System.err.println("Must be of numeric value!!!\n");
    continue;
    }   
//          if(option.equalsIgnoreCase("6")){
//                System.out.print("Enter text: ");
//
//    }

   
       
 
     switch (option) {
      case "1":   
             start_time = System.currentTimeMillis(); 
               for(int i=0; i<times; i++){  
                userInput = rmi.getDateRequest();
                System.out.println(userInput);
               }
             end_time = System.currentTimeMillis();
           
        break;
      case "2":
             start_time = System.currentTimeMillis(); 
               for(int i=0; i<times; i++){  
                userInput = rmi.getProcesses();
                System.out.println(userInput);
               }
             end_time = System.currentTimeMillis();
                
        break;
      case "3":
            start_time = System.currentTimeMillis(); 
              for(int i=0; i<times; i++){  
                userInput = rmi.getSockets();
                System.out.println(userInput);
              }
             end_time = System.currentTimeMillis();
           
        break;
      case "4":
            start_time = System.currentTimeMillis();
              for(int i=0; i<times; i++){  
                userInput = rmi.getBootRequest();
                System.out.println(userInput);
              }
             end_time = System.currentTimeMillis();
              
        break;
      case "5":
            start_time = System.currentTimeMillis();
              for(int i=0; i<times; i++){  
                userInput = rmi.getCurrentUsers();
                System.out.println(userInput);
              }
             end_time = System.currentTimeMillis();
                
        break;
        
      case "6":
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter text: ");
             String input = scan.nextLine();
             
                
           //  String output;
       // for(int j=0; j<times; j++){
           
            start_time = System.currentTimeMillis(); 
            for(int i=0; i<times; i++){  
           userInput = rmi.getEchoBack(input); 
            System.out.println(userInput);
            }
          // }
             end_time = System.currentTimeMillis();
           
        break;
        
      default:
            System.err.println("Please select a valid option!!!!");
            continue;
            }

        
   
        System.out.println("--" + "This command took " + (end_time-start_time) + "ms");
        
        
            }
    
 
    }
    
    
       
                 
        catch(NumberFormatException | NotBoundException | IOException e){
            System.out.println(e);
          
        }
    
    }
    
}
     
     


