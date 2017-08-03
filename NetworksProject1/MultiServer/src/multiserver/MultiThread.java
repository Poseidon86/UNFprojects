
package multiserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * This class processes multiple client requests while the server remains open
 * @author Christian and Brian
 */
public class MultiThread extends Thread {
    Socket s = null;
    
    public MultiThread(Socket clientSocket){
        this.s = clientSocket;
    } //end constructor
    
    @Override
    public void run(){
            System.out.println("Client connected...starting " + Thread.currentThread().getName() );
            
            try{
              
       PrintWriter out = new PrintWriter(s.getOutputStream(), true);
       BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
       
      while(true){         
   
       String option = in.readLine();
       String send = "str";
        

                Process cmdProc;
		cmdProc=null;
                
                
            //Checks for special characters    
           if(option.equalsIgnoreCase( "/*!@#$%^&*()\"{}_[]|\\?/<>,.")){
                   System.err.println("Unrecognized option...please try again");
                   return;
               }//end if
            
        
		// Execute the appropriate command.
               
		switch (option){
                    case "MC:1": 
                        System.out.println("Responding to date request from the client ");
			String[] cmd = {"bash", "-c", "date"};
			cmdProc = Runtime.getRuntime().exec(cmd);
                        break;
                    case "MC:2":
                        System.out.println("Responding to number of processes(running) request from the client ");
                        String[] cmdA = {"bash", "-c", "ps -ef | wc -l"};
			cmdProc = Runtime.getRuntime().exec(cmdA);
                        break;
                    case "MC:3":
                        System.out.println("Responding to number of active socket connections request from the client ");
                        String[] cmdB = {"bash", "-c", "ss -t -a | grep ESTAB | wc -l"};
			cmdProc = Runtime.getRuntime().exec(cmdB);
                        break;
                    case "MC:4":
                        System.out.println("Responding to time of last system boot request from the client ");
                        String[] cmdC = {"bash", "-c", "who -b"};
			cmdProc = Runtime.getRuntime().exec(cmdC);
                        break;
                    case "MC:5":
                        System.out.println("Responding to current users request from the client ");
                        String[] cmdD = {"bash", "-c", "users"};
			cmdProc = Runtime.getRuntime().exec(cmdD);
                        break;
                    case "MC:6":
                        System.out.println("Responding to echo back request from the client ");
                        
                        send = in.readLine();
                        out.println(send);
                       String[] cmdE = {"bash", "-c", send};
                      cmdProc = Runtime.getRuntime().exec(cmdE);
                        break;
                    case "MC:7":
                        System.out.println("Quitting...");
                        String[] cmdF = {"bash", "-c", "exit"};
			cmdProc = Runtime.getRuntime().exec(cmdF);
                        s.close();
                        break;
                    default:
                        System.out.println("Unknown request ");
	
			return;
                        
                }//end switch
                
                if(option.equals("MC:6 ")){
                    out.println(send);
                }//end if
                
                // Read the result of the commands and send the result to the client one line at a time
		// followed by the line "ServerDone"
                else{
		BufferedReader cmdin = new BufferedReader(new InputStreamReader(cmdProc.getInputStream()));

		String cmdans;
		while((cmdans = cmdin.readLine()) != null)		
			out.println(cmdans); 
       
                }//end else
		
                out.println("ServerDone");

        }//end while
           
        }//end try
    catch (IOException e){
        System.out.println("Exception caught " + e);
            System.out.println(e.getMessage());
    }// end catch
  
}//end run()
} //end class MultiThread


                
                
     

