package model.card.hazard;

import model.card.Card;

/**
 * This class create a new SpeedLimit card.
 * @version 1.0
 * @author Tasos Anastasas
 */
public class SpeedLimit extends Hazard{

    /**
     * Constructor: Constructs a new instance of SpeedLimit and via the
     * parent class Hazard sets with the command super,
     * cardName=Speed Limit,type=SL
     */
    public SpeedLimit() {
        super("Speed Limit","SL");
    }

    /**
     * Observer: Return if the card C match with the instance that called
     * Postcondition: card C has been set
     * @param c card 
     * @return Return if the card C match with the instance that called
     */
    @Override
    public boolean match(Card c) {
        return c instanceof Hazard;
        
    }
}
