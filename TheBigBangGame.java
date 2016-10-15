/*
* Au/thor: Christian Wilson
* Course: COP2551
* Project #: 3
* Title : Rock-Paper-Scissors-Lizard-Spock
* Due Date: 3/27/2016
*
* Plays The Big Bang Theory inspired game Rock-Paper-Scissors-Lizard-Spock. */
package thebigbanggame;
/**
 * Plays The Big Bang Theory inspired game Rock-Paper-Scissors-Lizard-Spock. */

public class TheBigBangGame {
    private static final String LEONARD = "Leonard";
    private static final String SHELDON = "Sheldon";
    
    
    
    public static void main(String[] args) {
        
    System.out.format("Christian Wilson%nRock-Paper-Scissors-Lizard-Spock%n");
    
    TheBigBangGame game = new TheBigBangGame(); 
    game.execute(args);
    
    }
    /**
     * Displays result to the user.
     * @param sheldonsInitialMove
     * @param sheldonWins
     * @param leonardsInitialMove
     * @param leonardWins
     * @param ties 
     */
    private static void displayResults(String sheldonsInitialMove, int sheldonWins, String leonardsInitialMove, int leonardWins, int ties){
        
      
    
        
        
        System.out.format("%n"+SHELDON + "'s Initial Move: " + sheldonsInitialMove+"%n");
        System.out.format(LEONARD + "'s Initial Move: " + leonardsInitialMove+"%n");
        
        if (leonardWins==sheldonWins){
            System.out.format("%nTIE GAME!%n");
            System.out.format(SHELDON+" and "+LEONARD+" each won " +leonardWins+ " game(s) and they tied "+ties+ " game(s)."+"%n");
        }
            else if (leonardWins > sheldonWins){
                   System.out.format("%n"+LEONARD+ " WINS!"+"%n");
                   System.out.format(SHELDON+" won " +sheldonWins+ " game(s), "+LEONARD+" won " +leonardWins+ " game(s), and they tied "+ties+ " game(s)."+"%n");
                    }
                    else{
                    System.out.format("%n"+SHELDON+ " WINS!"+"%n");
                    System.out.format(SHELDON+" won " +sheldonWins+ " game(s), "+LEONARD+" won " +leonardWins+ " game(s), and they tied "+ties+ " game(s)."+"%n");
                    }
                    
                    
        

        
        
    }
    /**
     * Starts the game.
     * @param args 
     */
    private void execute(String[] args){
        
     
      Game Game = new Game();

      Game.sheldonsInitialMove = Game.convertShape(args[0].toUpperCase());
      Game.leonardsInitialMove = Game.convertShape(args[1].toUpperCase());
      Game.numberGames = Integer.parseInt(args[2]);
      Game.playGame(Game.sheldonsInitialMove,Game.leonardsInitialMove,Game.numberGames);
      displayResults(args[0].toUpperCase(), Game.getSheldonsWinCount(), args[1].toUpperCase(), Game.getLeonardsWinCount(), Game.getTieCount());
      
      
    }
    }
    

