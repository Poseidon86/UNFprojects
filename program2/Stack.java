
package program2;

import java.util.ArrayList;

/**
 *Responsible for handling the stack to update priority queues.
 * @author Christian Wilson
 * @param none
 * @return void
 */
public class Stack {
    
  
    
   
    private ArrayList<Presidents> stackPres;
    private int top;
    
    /**
     * The constructor for the stack
     * @param none
     * @return void
     */
    public Stack(){
         
        stackPres = new ArrayList();
        top = -1;
    }//end Stack()
    
    
    /**
     * Adds elements to top of stack
     * @param e 
     * @return void
     */
    public void push(ArrayList<Presidents> e){
        
       stackPres.add(e.get(++top));        
    }//end push()
    
    
    /**
     * Returns top of stack and decrements index for the top of the stack.
     * @param none
     * @return The element at the top of stack.
     */
    public Presidents pop(){
        
       return  stackPres.get(top--);
    }//end pop()
    
    
    /**
     * Determines whether or not the stack is empty.
     * @param none
     * @return true if top is equal to -1.
     */
    public boolean isEmpty(){
        
        return (top == -1);
    }//end isEmpty()
    
    
    /**
     * Determines whether or not the stack is full.
     * @param none
     * @return The stack cannot be full
     */
    public boolean isFull(){
        
        return false;
    }//end isFull()
    
    
    /**
     * Displays the stack
     * @param none
     * @return void
     */
    public void displayStack(){
        
        int var= top;
        
        System.out.println("\n\n\n\nInput Stack for Updating Priority Queues");
        System.out.printf("\n%-8s%-30s%-18s", "Number", "Name", "Party\n");
        System.out.printf("\nTop of stack: ");
       
        while(var != -1){
             System.out.printf("\n%-8s%-30s%-18s",stackPres.get(var).getNumber() ,stackPres.get(var).getName(),stackPres.get(var--).getParty());
        }//end while
        
        System.out.println("\nBottom of stack");
          //System.out.println();
        }//end displayStack()
    
    }//end Stack class
    
    

