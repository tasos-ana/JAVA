package model.card.hazard;

import model.card.Card;

/**
 * This class create a new FlatTire card.
 * @version 1.0
 * @author Tasos Anastasas
 */
public class FlatTire extends Hazard {

    /**
     * Constructor: Constructs a new instance of FlatTire and via the
     * parent class Hazard sets with command super,
     * cardName=Flat Tire,type=C
     */
    public FlatTire() {
        super("Flat Tire","C");
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
