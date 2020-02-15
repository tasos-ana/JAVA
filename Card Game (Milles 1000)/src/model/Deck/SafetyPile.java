package model.Deck;

import model.Sullogi.Sullogi;
import model.card.Card;

/**
 * SafetyPile contains the information from the card that putted from other
 * player to the SafetyPile
 *
 * @version 1.0
 * @author Tasos
 */
public class SafetyPile {

    private Sullogi card;
    private Deck d;

    /**
     * Transformer: initialize the deck
     * @param d new deck
     */
    public SafetyPile(Deck d) {
        card = new Sullogi();
        this.d = d;
    }

    /**
     * Transformer: add new card to the card Collection Postcondition: add new
     * card to the card Collection
     *
     * @param cd the new card
     * @return true if the card added successful, false otherwise
     */
    public boolean addCard(Card cd) {
        card.addCard(cd);
        if(d.getBattlePile().getCard()==null){
            return true;
        }
        if (d.isDrivingAce()) {
            if (d.getBattlePile().getCard().getCardName() == "Accident") {
                d.getBattlePile().removeCard();
            }
        }
        if (d.isExtraTank()) {
            if (d.getBattlePile().getCard().getCardName() == "Out of Gas") {
                d.getBattlePile().removeCard();
            }
        }
        if (d.isPunctureProof()) {
            if (d.getBattlePile().getCard().getCardName() == "Flat Tire") {
                d.getBattlePile().removeCard();
            }
        }
        if (d.isRightOfWay()) {
            if (d.getBattlePile().getCard().getCardName() == "Speed Limit") {
                d.getBattlePile().removeCard();
            }
            if (d.getBattlePile().getCard().getCardName() == "STOP") {
                d.getBattlePile().removeCard();
            }
        }
        return true;
    }

    /**
     * Observer: Return if the card list is empty
     * @return true if card value are 0, false otherwise
     */
    public boolean isEmpty() {
        return card.isEmpty();
    }

    /**
     * Accessors: Return all the array with cards
     * @return card
     */
    public Sullogi getAllCard() {
        return card;
    }
}
