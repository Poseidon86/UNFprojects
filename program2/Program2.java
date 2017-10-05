
package program2;


import java.io.IOException;
import java.util.ArrayList;


/**
 *Creates, sorts, and displays queues of president elements.
 * @author Christian Wilson
 * @param none
 * @return void
 */
public class Program2 {

/**
 * Executes operation of the program.
 * @param args the command line arguments
 * @throws IOException
 * @return void
 */
      
    public static void main(String[] args) throws IOException{
        
       ArrayList<Presidents> myPresidents;
    
        FileIO myFile = new FileIO();  
        Queue myQueues = new Queue();  
   

            myQueues.insertQue(myFile.readFile("Presidents.txt")); 
            myQueues.displayQueue();

           myQueues.selectionSort(); //sorts queue by number. 
            myQueues.displayPriority();

 
        Stack myStack = new Stack();
            myPresidents = myFile.updateFile("PresidentUpdate.txt");
            
        for(int i=0; i<myPresidents.size(); i++){     
            myStack.push(myPresidents); //fills the stack
       
   }//end for loop   
            myStack.displayStack();
       
       
       //Updates Queues
        while(!myStack.isEmpty()){
            myQueues.updatePriority(myStack.pop());
   }//end while
 
            myQueues.displayPriority();
      
   }//end main()
    
}//end Program2 class

     
 
    
     
   

       
    
    

