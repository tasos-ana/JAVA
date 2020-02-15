package model.card.remedy;

import model.card.Card;
import model.card.hazard.FlatTire;

/**
 * This class create a new SpareTire card.
 * @version 1.0
 * @author Tasos Anastasas
 */
public class SpareTire extends Remedy {

    /**
     * Constructor: Constructs a new instance of SpareTire and via the
     * parent class Remedy sets with the command super,
     * cardName=Spare Tire,type=RS
     */
    public SpareTire() {
        super("Spare Tire","RS");
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
     * Observer: Return if the card C is the card Flat Tire.
     * Postcondition: card C has been set
     * @param c card
     * @return true if the card c is FlatTire, false otherwise.
     */
    public boolean match2(Card c){
        return c instanceof FlatTire;
    }
}
