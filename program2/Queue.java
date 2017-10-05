
package program2;


import java.util.ArrayList;

/**
 *Handles each queue for president elements.
 * @author Christian Wilson
 * @param none
 * @return void
 */
public class Queue {
    
       
        private ArrayList<Presidents> queWhig;
        private int whigFront;
        private int whigRear;
        private int whigItems;
        
        private ArrayList<Presidents>queDem; 
        private int demFront;
        private int demRear ;
        private int demItems;  
        
        private ArrayList<Presidents> queRep;
        private int repFront;
        private int repRear;
        private int repItems;
        
    
 
    /**
     * The constructor for Queue class
     * @param none
     * @return void
     */
    public Queue(){
     
        queWhig = new ArrayList();
        whigFront =0;
        whigRear=-1;
        whigItems = 0;
        
        queDem = new ArrayList();
        demFront =0;
        demRear =-1;
        demItems =0;
        
        queRep = new ArrayList();
        repFront =0;
        repRear =-1;
        repItems =0;
       
    }//end Queue() constructor
    
  
    /**
     * Inserts presidents into proper queue positions
     * @param presidents 
     * @return void
     */
     public void insertQue(ArrayList<Presidents> presidents){
        for(int i=0; i<presidents.size(); i++)
             if(presidents.get(i).getParty().compareTo("Democrat")==0){
                queDem.add(++demRear,presidents.get(i));
                  demItems++;                                   
            }//end if
             
              else if(presidents.get(i).getParty().compareTo("Republican")==0){
                queRep.add(++repRear, presidents.get(i));
                   repItems++;
            }//end else if
              
              else if(presidents.get(i).getParty().compareTo("Whig")==0){      
                queWhig.add(++whigRear, presidents.get(i));
                   whigItems++;                  
            }//end else if   
 
        }// end insertQue()

    /**
     * Sorts presidents elements by number
     * @param none
     * @return void
     */
    public void selectionSort(){
          
         int out, in, min;
                  
        for(out =0; out<queDem.size()-1; out++){
           min = out;
          for(in=out+1; in<queDem.size(); in++)
            if(queDem.get(in).getNumber() < queDem.get(min).getNumber())
                min = in;
                swap(queDem, out, min);       
        }//end for out
        
        for(out =0; out<queRep.size()-1; out++){
           min = out;
          for(in=out+1; in<queRep.size(); in++)
            if(queRep.get(in).getNumber() < queRep.get(min).getNumber())
                min = in;
                swap(queRep, out, min);
        }//end for out
        
        for(out =0; out<queWhig.size()-1; out++){
           min = out;
          for(in=out+1; in<queWhig.size(); in++)
            if(queWhig.get(in).getNumber() < queWhig.get(min).getNumber())
                min = in;
                swap(queWhig, out, min);
        }//end for out
        
    }//end selectionSort()
    
    /**
     * Swaps values between the two specified locations in an array.
     * @param presidents ArrayList of presidents
     * @param pos1 Position of first value to swap.
     * @param pos2 position of second value to swap.
     * @return void
     */
    private void swap(ArrayList<Presidents> presidents, int pos1, int pos2)
    {
        Presidents temp = presidents.get(pos1);
            presidents.set(pos1, presidents.get(pos2));
            presidents.set(pos2, temp);
       
              
} //end swap()
    
    /**
     * Updates the sorted queues with the president element.
     * @param president element to be passed.
     * @return void
     */
    public void updatePriority(Presidents president){
        int j;
        Presidents temp;
        
        if (president.getParty().compareTo("Democrat")==0){
            queDem.add(president);
            temp = queDem.get(queDem.size() - 1);
        
        for(j = queDem.size() - 1; j>=0; j--)
            if(temp.getNumber() < queDem.get(j).getNumber()){
               swap(queDem, j,j+1);

            }//end if
            
    }//end if
        
        else if (president.getParty().compareTo("Republican")==0){
            queRep.add(president);
            temp = queRep.get(queRep.size() - 1);
            
        for(j = queRep.size() - 1; j>=0; j--)
            if(temp.getNumber() < queRep.get(j).getNumber()){
                swap(queRep, j, j+1); 
                
            }//end if
 
    }//end else if
    
      else if (president.getParty().compareTo("Whig")==0){
            queWhig.add(president);
            temp = queWhig.get(queWhig.size() - 1);
            
        for(j = queWhig.size() - 1; j>=0; j--)
            if(temp.getNumber() < queWhig.get(j).getNumber()){
                swap(queWhig, j, j+1);
                
            }//end if

    }//end else if

    }//end UpdatePriority()
    
    /**
     * Displays the Sorted Priority Queues
     * @param none
     * @return void
     */
    public void displayPriority(){
        System.out.println("\n\n\n\nSorted Priority Queues\n\nQueue 1: Democrats");
        System.out.printf("\n%-8s%-30s%-18s", "Number", "Name", "Party\n");
        
        for(int i=0;i<queDem.size(); i++){     
            System.out.printf("\n%4d  %-30s%-18s",queDem.get(i).getNumber(),queDem.get(i).getName(),queDem.get(i).getParty());
       }// end for loop
       
        System.out.println("\n\n\nQueue 2: Republicans");
        System.out.printf("\n%-8s%-30s%-18s", "Number", "Name", "Party\n");
        
        for(int i=0;i<queRep.size(); i++){
            System.out.printf("\n%4d  %-30s%-18s",queRep.get(i).getNumber(),queRep.get(i).getName(),queRep.get(i).getParty());         
       }// end for loop
        
        System.out.println("\n\n\nQueue 3: Whigs");
        System.out.printf("\n%-8s%-30s%-18s", "Number", "Name", "Party\n");
        
        for(int i=0;i<queWhig.size(); i++){
            System.out.printf("\n%4d  %-30s%-18s",queWhig.get(i).getNumber(),queWhig.get(i).getName(),queWhig.get(i).getParty());
       }// end for loop
        
    }//end displayPriority()
    
    /**
     * Displays the Unsorted Queues
     * @param none
     * @return void
     */
   public void displayQueue(){
       System.out.println("Unsorted Queues\n\nQueue 1: Democrats");
       System.out.printf("\n%-8s%-30s%-18s", "Number", "Name", "Party\n");
       
       for(int i=0;i<queDem.size(); i++){      
            System.out.printf("\n%4d  %-30s%-18s",queDem.get(i).getNumber(),queDem.get(i).getName(),queDem.get(i).getParty());
       }// end for loop
       
       System.out.println("\n\n\nQueue 2: Republicans");
       System.out.printf("\n%-8s%-30s%-18s", "Number", "Name", "Party\n");
       
        for(int i=0;i<queRep.size(); i++){
            System.out.printf("\n%4d  %-30s%-18s",queRep.get(i).getNumber(),queRep.get(i).getName(),queRep.get(i).getParty());         
       }// end for loop
        
        System.out.println("\n\n\nQueue 3: Whigs");
        System.out.printf("\n%-8s%-30s%-18s", "Number", "Name", "Party\n");
        
        for(int i=0;i<queWhig.size(); i++){
            System.out.printf("\n%4d  %-30s%-18s",queWhig.get(i).getNumber(),queWhig.get(i).getName(),queWhig.get(i).getParty());        
       }// end for loop
      
   }//end displayQueue()
   

    
    
    /**
     * Determines whether or not the queue is empty
     * @param none
     * @return true of the number of items equals 0.
     */
    public boolean queEmpty(){
      
        return (demItems==0 && repItems==0 && whigItems==0);
    }//end queEmpty()
    
    /**
     * Determines whether or not the queue is full.
     * @param none
     * @return The queue cannot be full
     */
    public boolean queFull(){
       
        return false;
    }//end queFull
    
    /**
     * Prints the size of the queue.
     * @param none
     * @return void
     */
    public void size(){
       
            System.out.println("\n\n"+demItems);
            System.out.println("\n"+repItems);
            System.out.println("\n"+whigItems);
        }//end size()
     
    }//end Queue class



