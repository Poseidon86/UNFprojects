
package thebigbanggame;


public class Game {
    
    private final int SHELDON_WINS = 0, LEONARD_WINS = 1, TIE = 2, ROCK = 0, PAPER = 1, SCISSORS = 2, LIZARD = 3, SPOCK = 4;
    
    private int leonardsMove, leonardsWinCount, sheldonsMove, sheldonsWinCount, tieCount;

    public int sheldonsInitialMove, leonardsInitialMove, numberGames, gameOutcome, sheldonsPreviousMove;

/**
 * Converts constant integer to a string.
 * @param shape 
 * @return 
 */
public int convertShape(String shape){
    int newShape = 0; 
            
    switch(shape){
        case "ROCK":
            newShape = ROCK;
            break;
        
        case "PAPER":
            newShape = PAPER;
            break;
            
        case "SCISSORS":
            newShape = SCISSORS;
            break;
           
        case "LIZARD":
            newShape = LIZARD;
            break;
        
        case "SPOCK":
            newShape = SPOCK;
            break;
         
            
    }

    return newShape;
 
}
/**
 * Determines Leonards next move based on Sheldons last move or tie.
 * @param sheldonsLastMove
 * @param leonardsLastMove
 * @param gameOutcome 
 */
private void determineLeonardsNextMove(int sheldonsLastMove, int leonardsLastMove, int gameOutcome){
    
    switch(gameOutcome){
        case LEONARD_WINS:
          leonardsMove = leonardsLastMove;
          break;
          
        case SHELDON_WINS:
          leonardsMove = getBetterMove(sheldonsLastMove); 
          break;
          
        case TIE:
          leonardsMove = getBetterMove(leonardsLastMove);
          break;
    }
  
}
/**
 * Determines Sheldons next move based on Leonards last move or tie.
 * @param sheldonsLastMove
 * @param leonardsLastMove
 * @param gameOutcome 
 */
private void determineSheldonsNextMove(int sheldonsLastMove, int leonardsLastMove, int gameOutcome){
    
    //sheldonsPreviousMove = sheldonsLastMove;
    
    if(sheldonsLastMove != SPOCK){
        sheldonsMove = SPOCK;
    }
    else if (gameOutcome == SHELDON_WINS){
        sheldonsMove = ROCK;
    }
    else if (gameOutcome == LEONARD_WINS){
        sheldonsMove = PAPER;
    }
    else
        sheldonsMove = LIZARD;
    
    
}
/**
 * Determines the winner based on each players moves.
 * @param sheldonsMove
 * @param leonardsMove 
 */
private void determineWinner(int sheldonsMove, int leonardsMove){
    
    
  if(sheldonsMove == ROCK &&(leonardsMove == SCISSORS || leonardsMove == LIZARD)){
        gameOutcome = SHELDON_WINS;
        
    }
    else if(sheldonsMove == SPOCK &&(leonardsMove == SCISSORS || leonardsMove == ROCK)){
        gameOutcome = SHELDON_WINS;
        
    }
    else if(sheldonsMove == LIZARD &&(leonardsMove == SPOCK || leonardsMove == PAPER)){
        gameOutcome = SHELDON_WINS;
       
    }
    else if(sheldonsMove == PAPER &&(leonardsMove == ROCK || leonardsMove == SPOCK)){
        gameOutcome = SHELDON_WINS;
      
    }
    else if(sheldonsMove == SCISSORS &&(leonardsMove == PAPER || leonardsMove == LIZARD)){
        gameOutcome = SHELDON_WINS;
      
    }
    else if(sheldonsMove == leonardsMove) {
        gameOutcome = TIE;
      
    }
    else 
        gameOutcome = LEONARD_WINS;
   
       
}
/**
 * Used to get a better for Leonard, only if Sheldon wins or ties.
 * @param lastMove
 * @return 
 */
private int getBetterMove(int lastMove){
    int newMove = 0; 
    
   switch(lastMove){
       case ROCK:
           newMove = PAPER;
           break;
           
       case PAPER:
           newMove = SCISSORS;
           break;
           
       case SCISSORS:
           newMove = SPOCK;
           break;
           
       case LIZARD:
           newMove = ROCK;
           break;
           
       case SPOCK:
           newMove = LIZARD;
           break;                      
   }    
    return newMove;
}
/**
 * Gets Leonards win count.
 * @return 
 */
public int getLeonardsWinCount(){
    int wins = leonardsWinCount;
   
    return wins ;
}
/**
 * Gets Sheldons win count.
 * @return 
 */
public int getSheldonsWinCount(){
    int wins = sheldonsWinCount;
   
    return wins ;
    
}
/**
 * Gets tie count.
 * @return 
 */
public int getTieCount(){
    int ties = tieCount;
   
    return ties ;
}
/**
 * Plays the game.
 * @param sheldonsInitialMove
 * @param leonardsInitialMove
 * @param numberGames 
 */

public void playGame(int sheldonsInitialMove, int leonardsInitialMove, int numberGames){
    sheldonsMove=sheldonsInitialMove;
    leonardsMove=leonardsInitialMove;
    
      
    for (int i = numberGames; i>0;){                        
       determineWinner(sheldonsMove, leonardsMove);
       determineLeonardsNextMove(sheldonsMove, leonardsMove, gameOutcome);
       determineSheldonsNextMove(sheldonsMove, leonardsMove, gameOutcome);
       updateScores(gameOutcome); 
       i--;       
      }
   
}
/**
 * Updates scores.
 * @param gameOutcome 
 */
private void updateScores(int gameOutcome){
    
    switch(gameOutcome){
        case SHELDON_WINS:
           sheldonsWinCount++;
           break;
           
        case LEONARD_WINS:
            leonardsWinCount++;
           break;
           
        case TIE:
            tieCount++;
           break;
    }
   
    
}
}

