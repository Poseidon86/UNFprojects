
package program2;

/**
 *Getters and setters for all presidents attributes.
 * @author Christian
 * @param none
 * @return void
 */
public class Presidents {
    
    private int number;
    private String name;
    private String code;
    private int yearsOffice;
    private String party;
    private String homeState;
    
    
    /**
     * The constructor for presidents attributes
     * @param pNum Presidents number
     * @param pName Presidents name
     * @param pCode Presidents code
     * @param pYears Presidents years in office
     * @param pParty Presidents party
     * @param pState Presidents home state
     * @return void
     */
    public Presidents (int pNum, String pName, String pCode, int pYears, String pParty, String pState)
    {
        number = pNum;
        name = pName;
        code = pCode;
        yearsOffice = pYears;
        party = pParty;
        homeState = pState;
        
} //end Presidents()


   /**
    * Returns a formatted string
    * @param none
    * @return a formatted string
    */
@Override
    public String toString()
    {
        return String.format("%-20s\t\t%-30s%-30s",number, name, party);
}

    
    /**
     * Returns the presidents number
     * @param none
     * @return the presidents number
     */
    public int getNumber()
    {
        return number;
}

    /**
     * Returns the presidents years in office
     * @param none
     * @return the presidents years in office
     */
    public int getYearsOffice()
    {
        return yearsOffice;
}
    /**
     * Returns the presidents code
     * @param none
     * @return the presidents code
     */   
    public String getCode()
    {
        return code;
}

    /**
     * Returns the presidents name
     * @param none
     * @return the presidents name
     */
    public String getName()
    {
        return name;
}

    /**
     * Returns the presidents party
     * @param none
     * @return the presidents party
     */
    public String getParty()
    {
        return party;
}

    /**
     * Returns the presidents home state
     * @param none
     * @return the presidents home state
     */
    public String getHomeState()
    {
        return homeState;
}
    
} //end class Presidents


