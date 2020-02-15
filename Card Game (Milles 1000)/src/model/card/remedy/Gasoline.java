package model.card.remedy;

import model.card.Card;
import model.card.hazard.OutOfGas;

/**
 * This class create a new Gasoline card.
 * @version 1.0
 * @author Tasos Anastasas
 */
public class Gasoline extends Remedy {

    /**
     * Constructor: Constructs a new instance of Gasoline and via the
     * parent class Remedy sets with the command super,
     * cardName=Gasoline,type=E
     */
    public Gasoline() {
        super("Casoline","E");
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
     * Observer: Return if the card C is the card out of gas.
     * Postcondition: card C has been set
     * @param c card
     * @return true if the card c is OutOfGas, false otherwise.
     */
    public boolean match2(Card c){
        return c instanceof OutOfGas;
    }
}
