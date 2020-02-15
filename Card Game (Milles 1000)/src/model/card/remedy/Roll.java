package model.card.remedy;

import model.card.Card;
import model.card.hazard.Stop;

/**
 * This class create a new Roll card.
 * @version 1.0
 * @author Tasos Anastasas
 */
public class Roll extends Remedy {

    /**
     * Constructor: Constructs a new instance of Roll and via the
     * parent class Remedy sets with the command super,
     * cardNameType=Roll
     */
    public Roll() {
        super("ROLL");
    }

    /**
     * Observer: Return if the card C match with the instance that called
     * Postcondition: card C has been set
     * @param c card 
     * @return Return if the card C match with the instance that called
     */
    @Override
    public boolean match(Card c) {
        return c instanceof Remedy;
    }
    
    /**
     * Observer: Return if the card C is the card stop.
     * Postcondition: card C has been set
     * @param c card
     * @return true if the card c is Stop, false otherwise.
     */
    public boolean match2(Card c){
        return c instanceof Stop;
    }
}
