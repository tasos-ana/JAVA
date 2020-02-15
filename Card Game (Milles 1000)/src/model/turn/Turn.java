package model.turn;

/**
 * This class represents the turn of the game
 * @version 1.0
 * @author Tasos Anastasas
 */
public class Turn {
    
    private int currentID;
    
    /**  Constructor.
     *Postcondition:Creates a new instance of Turn with currentID=0, 
     */
    public Turn(){
        currentID=1;
    }
    
    /**
     * Transformer:Sets the player turn.(which player has the turn to play)
     * Postcondition:Player turn has been set.
     * @param id
     */
    public void setID(int id){
        this.currentID=id;
    }
    
    /**
     * Accessors: returns the player ID whose turn is to play
     * Postcondition:returns the player ID whose turn is to play
     * @return the player ID whose turn is to play
     */
    public int getID(){
        return this.currentID;
    }
}
