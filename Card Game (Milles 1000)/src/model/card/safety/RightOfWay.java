package model.card.safety;

import model.card.Card;
import model.card.hazard.SpeedLimit;
import model.card.hazard.Stop;

/**
 * This class create a new RightOfWay card.
 *
 * @version 1.0
 * @author Tasos Anastasas
 */
public class RightOfWay extends Safety {

    /**
     * Constructor: Constructs a new instance of RightOfWay and via the parent
     * class Safety sets with the command super, cardName=Right of Way,type=ROW
     */
    public RightOfWay() {
        super("Right of Way", "ROW");
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
     * Observer: Return if the card C is the card speed limit.
     * Postcondition: card C has been set
     * @param c card
     * @return true if the card c is SpeedLimit, false otherwise.
     */
    public boolean match2(Card c) {
        if(c instanceof Stop){
            return true;
        }
        else return c instanceof SpeedLimit;
    }
}
