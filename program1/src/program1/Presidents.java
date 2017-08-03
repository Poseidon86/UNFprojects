package program1;

/**
 * Provides properties and methods for a Presidents
 * 
 */
public class Presidents
{
          
    private int number;
    private String name;
    private String code;
    private int yearsOffice;
    private String party;
    private String homeState;
    
    
    /**
     * 
     * @param pNum Presidents number
     * @param pName Presidents name
     * @param pCode Presidents code
     * @param pYears Presidents years in office
     * @param pParty Presidents party
     * @param pState Presidents home state
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
    * @return a formatted string
    */
@Override
    public String toString()
    {
        return String.format("%-20s\t\t%-30s%-30s",number, name, party);
}

    
    /**
     * Returns the presidents number
     * @return the presidents number
     */
    public int getNumber()
    {
        return number;
}

    /**
     * Returns the presidents years in office
     * @return the presidents years in office
     */
    public int getYearsOffice()
    {
        return yearsOffice;
}
    /**
     * Returns the presidents code
     * @return the presidents code
     */   
    public String getCode()
    {
        return code;
}

    /**
     * Returns the presidents name
     * @return the presidents name
     */
    public String getName()
    {
        return name;
}

    /**
     * Returns the presidents party
     * @return the presidents party
     */
    public String getParty()
    {
        return party;
}

    /**
     * Returns the presidents home state
     * @return the presidents home state
     */
    public String getHomeState()
    {
        return homeState;
}
    
} //end class Presidents
