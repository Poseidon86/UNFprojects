package program1;

/**
 *Provides properties and methods for the PresidentMDrvr class
 * 
 */
public class PresidentMDrvr
{
  
    
    private Presidents[] myPresidents; //reference to array
    private int numPresidents;         // number of data items 
    

  
/**
 * Creates an object instance of the PresidentMDrvr class and initializes Presidents.
 * @param maxSize The maximum number of presidents stored.
 */
    public PresidentMDrvr(int maxSize) 
    {
        myPresidents = new Presidents[maxSize];
        numPresidents = 0; 
        
} //end PresidentMDrvr()
    
    
    /**
     * Adds a president to the array
     * @param president The president to add.
     */
    public void add(Presidents president)
    {
        myPresidents[numPresidents++] = president;
        
} //end add()
    
/**
 * Displays list of presidents and attributes.
 */
    public void displayPresidents()
    {
       
        for (int i =0; i<myPresidents.length; i++)
            System.out.println(myPresidents[i].toString());
        
        
} //end displayPresidents()
    
    
/**
 * Sorts array by president name using bubble sort algorithm.
 */ 
    public void sortByName()
    {
        for (int y=0; y<myPresidents.length;y++)
            for(int x=0; x< myPresidents.length-1;x++)
                if(myPresidents[x].getName().compareToIgnoreCase(myPresidents[x+1].getName()) > 0)
                    swap(x, x+1);
    
} // end sortByName()
    
/**
 * Sorts array by president number(ascending) using bubble sort algorithm.
 */
    public void sortByNumber()
    {
        for (int y=0; y<myPresidents.length;y++)
            for(int x=0; x< myPresidents.length-1;x++)
                if(myPresidents[x].getNumber() > myPresidents[x+1].getNumber())
                    swap(x, x+1);
                       
} // end sortByNumber()
 
/**
 * Swaps values between the two specified locations in an array.
 * @param pos1 Position of first value to swap.
 * @param pos2 position of second value to swap.
 */
    private void swap(int pos1, int pos2)
    {
        Presidents temp = myPresidents[pos1];
            myPresidents[pos1] = myPresidents[pos2];
            myPresidents[pos2] = temp;
              
} // end swap()
 
    /**
     * Algorithm checks every position until it finds target value. 
     * @param search The string value to be searched.
     */
    public void sequentialSearch(String search){
           int count = 0;
           boolean found = false;
           
        for (int i=0; i<myPresidents.length; i++)
            if(myPresidents[i].getParty().equals(search)){
               count++; 
               found = true;              
              
            }
            if (found == true)
                System.out.format("%-20s\t\t%-30s%-30s%n", search, "Found", count);
            else
                System.out.format("%-20s\t\t%-30s%-30s%n", search, "Not Found", "- ");
                       
        
}  // end sequentialSearch()   
    
    
   
       
           
    /**
     * Algorithm finds the position of the target value within a sorted array.
     * @param searchKey The data representing array to be searched.
     * @param currentTarget The position in the array.
     * @return 
     */
      
    public int binarySearch(String[] searchKey, int currentTarget){
        
            String searchString = searchKey[currentTarget];
            int lowerBound = 0;          
            int upperBound = myPresidents.length-1;
            int curIn;           
            int count = 0;
           
            sortByName();
           
    
        while(true)          
        {
            
           
           curIn = (lowerBound + upperBound)/2;
          
          
            if(myPresidents[curIn].getName().compareTo(searchString)==0){
		count++;
                System.out.format("%-20s\t\t%-30s%-30s%n", searchString, "Found", count);
              
                    return curIn;
            }
            
            else if(lowerBound > upperBound){                
                System.out.format("%-20s\t\t%-30s%-30s%n", searchString, "Not Found", count);
                
                    return curIn;
                      
            }
            
            else 
            {
                if((myPresidents[curIn].getName().compareTo(searchString)) < 0) {
                      lowerBound = curIn + 1;
                     
                }
            else
                      upperBound = curIn - 1;
                     
              }// end else divide range
            count++; 
         }  
        
     }  // end binarySearch()  
    
} // end PresidentMDrvr class

   
       


       
