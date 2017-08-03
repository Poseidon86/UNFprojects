
package multiserver;
import java.io.*;
import java.net.*;

/**
 * This class process requests from the client and returns results
 * @author Christian and Brian
 */
public class MultiServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    
    int portNumber = Integer.parseInt(args[0]);
        
      //must specify a port number when running application  
        if(args.length < 1){
            
            System.err.println("Usage: java Server <port number>");
            System.exit(1);
        }
      

        try{
        ServerSocket serverSocket = new ServerSocket(portNumber);
        System.out.println("Server started. Listening on Port " + portNumber);
        System.out.println("Waiting for clients");

     //Keep server open and accept multiple clients
      while(true){      

          new MultiThread(serverSocket.accept()).start();
      }
        }
        catch (IOException e){
            System.out.println("Exception caught" + e);
        }
        
       
    }
}
  