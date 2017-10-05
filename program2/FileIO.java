
package program2;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *Reads each input file and parses the data to each president attribute.
 * @author Christian Wilson
 * @param none
 * @return void
 * 
 */
public class FileIO {
    
  private ArrayList myPresidents;
 
                     
   /**
     * Reads data from the specified input file into the program. 
     * @param fileName The path and name of the input data file.
     * @throws IOException throws input/output exceptions.
     * @return The arraylist of presidents.
     */     
  public ArrayList readFile(String fileName) throws IOException {  
 
        int number, yearsOffice;
        myPresidents = new ArrayList();
        String line, name, code, party, homeState;
   
      
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        while((line = br.readLine()) != null){
        
               number =Integer.parseInt(line.substring(0,2).trim());
               name = line.substring(2,25).trim();
               code = line.substring(25,26).trim();
               yearsOffice = Integer.parseInt(line.substring(27,29).trim());
               party = line.substring(29,49).trim();
               homeState = line.substring(49, line.length()).trim();
                     
          myPresidents.add(new Presidents(number, name, code, yearsOffice, party, homeState));
             
         }//end while
        
        br.close();
      return myPresidents;

    }//end readFile()     
  
  /**
     * Reads data from the specified input file into the program. 
     * @param fileName The path and name of the input data file.
     * @throws IOException throws input/output exceptions.
     * @return The arraylist of presidents.
     */  
  public ArrayList updateFile(String fileName) throws IOException{
      int number, yearsOffice;
      String line, name, party, code, homeState;
      myPresidents = new ArrayList();
      
      BufferedReader br = new BufferedReader(new FileReader(fileName));

    while((line = br.readLine()) != null){
        
         number= Integer.parseInt(line.substring(0,2).trim());
         name = line.substring(2,17).trim();
         party = line.substring(17, line.length()).trim();
         code = null;
         homeState = null;
         yearsOffice = 0;
         
         myPresidents.add(new Presidents(number, name, code, yearsOffice, party, homeState));
                       
         }//end while
        
        br.close();
     
  return myPresidents;
                   
 }//end updateFile()
  
   
}//end FileIO class