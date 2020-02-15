package model.card.remedy;

import model.card.Card;
import model.card.hazard.Accident;

/**
 * This class create a new Repairs card.
 * @version 1.0
 * @author Tasos Anastasas
 */
public class Repairs extends Remedy {

    /**
     * Constructor: Constructs a new instance of Repairs and via the
     * parent class Remedy sets with the command super,
     * cardName=Repairs,type=R
     */
    public Repairs() {
        super("Repairs","R");
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
     * Observer: Return if the card C is the card Accident.
     * Postcondition: card C has been set
     * @param c card
     * @return true if the card c is Accident, false otherwise.
     */
    public boolean match2(Card c){
        return c instanceof Accident;
    }
}
