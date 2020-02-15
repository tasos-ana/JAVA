package model.card.safety;

import model.card.Card;
import model.card.hazard.FlatTire;

/**
 * This class create a new PunctureProof card.
 *
 * @version 1.0
 * @author Tasos Anastasas
 */
public class PunctureProof extends Safety {

    /**
     * Constructor: Constructs a new instance of PunctureProof and via the
     * parent class Safety sets with the command super, cardName=Puncture
     * Proof,type=PP
     */
    public PunctureProof() {
        super("Puncture Proof", "PP");
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
     * Observer: Return if the card C is the card flat tire.
     * Postcondition: card C has been set
     * @param c card
     * @return true if the card c is FlatTire, false otherwise.
     */
    public boolean match2(Card c) {
        return c instanceof FlatTire;
    }
}
