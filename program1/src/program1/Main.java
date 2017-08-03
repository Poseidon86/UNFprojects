package program1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *Manages presidents information
 * 
 */
public class Main {
   
    private final int MAX_PRESIDENTS = 44;
    private final int KEY_TOTAL = 7;
    private PresidentMDrvr presidentDrvr;
   
   
    
    public static void main(String[] args) throws IOException {
        
        new Main().execute();  
        
        
}// end main()
    
    /**
     * Controls the operation of the program
     * @throws IOException throws input/output exceptions.
     */    
    private void execute() throws IOException{
      
        readFile("Presidents.txt");  
        presidentDrvr.displayPresidents();
        System.out.println("\n\t----------------Sorted Presidents Array----------------\n");
	System.out.format("%-20s\t\t%-30s%-30s%n", "Number", "President", "Party\n");
	presidentDrvr.sortByNumber();
        presidentDrvr.displayPresidents();
        keyReader("Presidents_1.txt");       
        binaryDisplay();
    

}// end execute()
    
    
    /**
     * Creates an object instance of the Main class and initializes PresidentMDrvr.
     */
    public Main(){
        presidentDrvr = new PresidentMDrvr(MAX_PRESIDENTS);
        
}// end Main()
    
    /**
     * Reads data from the specified input file into the program. 
     * @param fileName The path and name of the input data file.
     * @throws IOException throws input/output exceptions.
     */    
    public void readFile(String fileName) throws IOException {        
        int number, yearsOffice;
        String line, name, code, party, homeState;

      
        BufferedReader br = new BufferedReader(new FileReader(fileName));
            System.out.println("\n\t----------------Unsorted Presidents Array----------------");
            System.out.format("%-20s\t\t%-30s%-30s%n", "Number", "President", "Party\n");
        while((line = br.readLine()) != null){
        
               number =Integer.parseInt(line.substring(0,2).trim());
               name = line.substring(2,25).trim();
               code = line.substring(25,26).trim();
               yearsOffice = Integer.parseInt(line.substring(27,29).trim());
               party = line.substring(29,49).trim();
               homeState = line.substring(49, line.length()).trim();
                          
           
             presidentDrvr.add(new Presidents(number, name, code, yearsOffice, party, homeState));
    } //end while  
            br.close();// close reader
} //end readFile()
    
      
    
        /**
        * Reads data from the specified input file into the program then displays the output from the sequential search algorithm.
        * @param fileName The path and name of the input data file.
        * @throws IOException throws input/output exceptions.
        */ 
    public void keyReader(String fileName) throws IOException{
                        
        String line;
        String[] key = new String[KEY_TOTAL];
                
        BufferedReader br = new BufferedReader(new FileReader(fileName));
            System.out.println("\n\t----------------Sequential Search on Party----------------");
            System.out.format("%-20s\t\t%-30s%-30s%n", "Search Argument", "Results", "Number Of Hits\n");
            
            for(int i=0; i<key.length; i++){
                key[i]= br.readLine().trim();
                line = key[i];
               
                
                 presidentDrvr.sequentialSearch(line);
            
            } //end for loop 
           
     br.close();// close reader
} //end keyReader()
    
   
    
    /**
    * Displays the output from the binary search algorithm.
    */
     public void binaryDisplay() {
       
    
       String[] binaryKey = new String [] {"Andrew Jackson", "Abraham Lincoln", "Billy Bob", "George Patton", "Harry Truman", "XXX"};
          
       
        System.out.println("\n\t-------------------Binary Search Results---------------------");
        System.out.format("%-20s\t\t%-30s%-30s%n", "Search Argument", "Results", "Number Of Probes\n");
       for(int i=0; i<binaryKey.length; i++){
                   
            presidentDrvr.binarySearch(binaryKey, i);
            } //end for loop
      
       } //end binaryDisplay()
            
} //end class Main
     

    
    

