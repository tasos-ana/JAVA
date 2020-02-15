package model.card.safety;

import model.card.Card;
import model.card.hazard.Accident;

/**
 * This class create a new DrivingAce card.
 * @version 1.0
 * @author Tasos Anastasas
 */
public class DrivingAce extends Safety {

    /**
     * Constructor: Constructs a new instance of DrivingAce and via the
     * parent class Safety sets with the command super,
     * cardName=Driving Ace,type=DA
     */
    public DrivingAce() {
        super("Driving Ace","DA");
    }

    /**
     * Observer: Return if the card C match with the instance that called
     * Postcondition: card C has been set
     * @param c card 
     * @return Return if the card C match with the instance that called
     */
    @Override
    public boolean match(Card c) {
        return c instanceof Safety;
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
