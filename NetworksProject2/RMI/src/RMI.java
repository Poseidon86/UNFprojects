/*
This interface provides the description of the methods that can be invoked by remote clients.
*/

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface RMI extends Remote{
    String getDateRequest() throws RemoteException;
    
    String getProcesses() throws RemoteException;
    
    String getSockets() throws RemoteException;
    
    String getBootRequest() throws RemoteException;
    
    String getCurrentUsers() throws RemoteException; 
    
    String quitProgram() throws RemoteException;

    String getEchoBack(String input) throws RemoteException;
    
    
}
