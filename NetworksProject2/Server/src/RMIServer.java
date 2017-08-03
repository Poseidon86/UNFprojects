/* This program implements the server side of a client-server application; the 
 * client connects to the server, then it requests the date and time, processes,
 * socket connections, last boot request, users, and echo back what is sent from the client. When 
 * the server receives a request over an established connection, it runs the 
 * appropriate Linux Bash command to generate the requested information, 
 * captures that information, and sends it back to the client that requested 
 * the information.The connection stays up until the client terminates it by sending an exit request.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class RMIServer implements RMI{

  
 

    
    public RMIServer() throws RemoteException{
        super();
    
    }// end constructor
  

    
    
    
    public static void main(String args[]){

   try{
            RMIServer rmi = new RMIServer();
            RMI stub = (RMI) UnicastRemoteObject.exportObject(rmi,0);
            
            Registry reg = LocateRegistry.createRegistry(5762);
          
            reg.bind("server", stub);
            System.out.println("Server started"); 
      }catch(RemoteException | AlreadyBoundException e){
            System.out.println(e);
        }
    }

    @Override
    public String getDateRequest() throws RemoteException {
        Process cmdProc = null;
        System.out.println("Responding to date request from the client ");
        try{
            String[] cmd = {"bash", "-c", "date"};
	    cmdProc = Runtime.getRuntime().exec(cmd);
        } catch(IOException ex){
            System.out.println(ex);
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(cmdProc.getInputStream()));
        String send = "";
        try{
            send = in.readLine();
        }catch(IOException ex){
            System.out.println(ex);
        }
        return send;
    }

    @Override
    public String getProcesses() throws RemoteException {
        Process cmdProc = null;
        System.out.println("Responding to number of processes(running) request from the client ");
        try{
             String[] cmdA = {"bash", "-c", "ps -ef | wc -l"};
             cmdProc = Runtime.getRuntime().exec(cmdA);
        } catch(IOException ex){
            System.out.println(ex);
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(cmdProc.getInputStream()));
        String send = "";
        try{
            send = in.readLine();
        }catch(IOException ex){
            System.out.println(ex);
        }
        return send;
    }

    @Override
    public String getSockets() throws RemoteException {
        Process cmdProc = null;
        System.out.println("Responding to number of active socket connections request from the client ");
        try{
             String[] cmdB = {"bash", "-c", "ss -t -a | grep ESTAB | wc -l"};
             cmdProc = Runtime.getRuntime().exec(cmdB);
        
        } catch(IOException ex){
           System.out.println(ex);
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(cmdProc.getInputStream()));
        String send = "";
        try{
            send = in.readLine();
        }catch(IOException ex){
           System.out.println(ex);
        }
        return send;
    }

    @Override
    public String getBootRequest() throws RemoteException {
        Process cmdProc = null;
        System.out.println("Responding to time of last system boot request from the client ");
        try{
            String[] cmdC = {"bash", "-c", "who -b"};
            cmdProc = Runtime.getRuntime().exec(cmdC); 
        } catch(IOException ex){
           System.out.println(ex);
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(cmdProc.getInputStream()));
        String send = "";
        try{
            send = in.readLine();
        }catch(IOException ex){
           System.out.println(ex);
        }
        return send;    
    }

    @Override
    public String getCurrentUsers() throws RemoteException {
        Process cmdProc = null;
        System.out.println("Responding to current users request from the client ");
        try{
          String[] cmdD = {"bash", "-c", "users"};
            cmdProc = Runtime.getRuntime().exec(cmdD);
        } catch(IOException ex){
           System.out.println(ex);
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(cmdProc.getInputStream()));
        String send = "";
        try{
            send = in.readLine();
        }catch(IOException ex){
           System.out.println(ex);
        }
        return send;    
    }

    @Override
    public String getEchoBack(String input) throws RemoteException {
         
        String send = "";
         Process cmdProc = null;
        System.out.println("Responding to echo back request from the client");
         
        try{  
     
         String[] cmdE = {"bash", "-c", "printf"};
         cmdProc = Runtime.getRuntime().exec(cmdE);
       }catch(IOException ex){
            System.out.println(ex);  
        }     
        try {
         BufferedReader in = new BufferedReader(new InputStreamReader(cmdProc.getInputStream()));
         send = in.readLine();
        }catch(IOException ex){
           System.out.println(ex);
        }
      
        return input;
    }
     @Override
    public String quitProgram() throws RemoteException {
 
        String send = "";
         Process cmdProc = null;
        System.out.println("Client has left the session...");
       try{
         
        String[] cmdF = {"bash", "-c", "exit"};
        cmdProc = Runtime.getRuntime().exec(cmdF);
        } catch(IOException ex){
            System.out.println(ex);
        }
       BufferedReader in = new BufferedReader(new InputStreamReader(cmdProc.getInputStream()));
        try{
            send = in.readLine();
        }catch(IOException ex){
            System.out.println(ex);
        }
        return send;
    }

  
    
}