package model.card.hazard;

import model.card.Card;

/**
 * This class create a new Stop card.
 * @version 1.0
 * @author Tasos Anastasas
 */
public class Stop extends Hazard{

    /**
     * Constructor: Constructs a new instance of Stop and via the
     * parent class Hazard sets with the command super,
     * cardNameType=Stop
     */
    public Stop() {
        super("STOP");
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
