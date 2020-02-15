package model.card.remedy;

import model.card.Card;
import model.card.hazard.SpeedLimit;

/**
 * This class create a new EndOfLimit card.
 * @version 1.0
 * @author Tasos Anastasas
 */
public class EndOfLimit extends Remedy {

    /**
     * Constructor: Constructs a new instance of EndOfLimit and via the
     * parent class Remedy sets with the command super,
     * cardName=End of Limit,type=EOL
     */
    public EndOfLimit() {
        super("End of Limit","EOL");
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
     * Observer: Return if the card C is the card speed limit.
     * Postcondition: card C has been set
     * @param c card
     * @return true if the card c is SpeedLimit, false otherwise.
     */
    public boolean match2(Card c){
        return c instanceof SpeedLimit;
    }
}
