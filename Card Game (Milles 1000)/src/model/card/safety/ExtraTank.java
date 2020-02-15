package model.card.safety;

import model.card.Card;
import model.card.hazard.OutOfGas;

/**
 * This class create a new ExtraTank card.
 *
 * @version 1.0
 * @author Tasos Anastasas
 */
public class ExtraTank extends Safety {

    /**
     * Constructor: Constructs a new instance of ExtraTank and via the parent
     * class Safety sets with the command super, cardName=Extra Tank,type=ET
     */
    public ExtraTank() {
        super("Extra Tank", "ET");
    }

    /**
     * Observer: Return if the card C match with the instance that called
     * Postcondition: card C has been set
     *
     * @param c card
     * @return Return if the card C match with the instance that called
     */
    @Override
    public boolean match(Card c) {
        return c instanceof Safety;
    }

    /**
     * Observer: Return if the card C is the card out of gas.
     * Postcondition: card C has been set
     * @param c card
     * @return true if the card c is OutOfGas, false otherwise.
     */
    public boolean match2(Card c) {
        return c instanceof OutOfGas;
    }
}
