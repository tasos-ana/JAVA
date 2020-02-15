package model.Deck;

import model.card.Card;
import model.card.hazard.SpeedLimit;
import model.card.remedy.EndOfLimit;
import model.card.remedy.Gasoline;
import model.card.remedy.Repairs;
import model.card.remedy.Roll;
import model.card.remedy.SpareTire;

/**
 * SpeedPile contains the information from the card's that putted from other
 * player to the speedPile
 *
 * @version 1.0
 * @author Tasos Anastasas
 */
public class SpeedPile {

    private Card card = null;
    private Deck d;

    /**
     * Transformer: initialize the deck
     * @param d new deck
     */
    public SpeedPile(Deck d) {
        this.d=d;
    }

    /**
     * Transformer: add new card to the card Collection Postcondition: add new
     * card to the card Collection
     * @param cd the new card
     * @return true if card added successful ,false otherwise
     */
    public boolean addCard(Card cd) {
        if( cd instanceof SpeedLimit){
            this.card=cd;
            return true;
        }
        
        if (cd instanceof EndOfLimit) {
            if (((EndOfLimit) cd).match2(d.getSpeedPile().getCard())) {
                card = null;
                return true;
            }
        }

        if (cd instanceof Gasoline) {
            if (((Gasoline) cd).match2(d.getBattlePile().getCard())) {
                d.getBattlePile().removeCard();
                return true;
            }
        }

        if (cd instanceof Repairs) {
            if (((Repairs) cd).match2(d.getBattlePile().getCard())) {
                d.getBattlePile().removeCard();
                return true;
            }
        }

        if (cd instanceof Roll) {
            if (((Roll) cd).match2(d.getBattlePile().getCard()) ||(d.getBattlePile().getCard()==null)) {
                d.getBattlePile().AddCard(cd);
                return true;
            }
        }

        if (cd instanceof SpareTire) {
            if (((SpareTire) cd).match2(d.getBattlePile().getCard())) {
                d.getBattlePile().removeCard();
                return true;
            }
        }

        return false;
    }

    /**
     * Accessors: return the card of the instance
     * @return card
     */
    public Card getCard() {
        return card;
    }
}
