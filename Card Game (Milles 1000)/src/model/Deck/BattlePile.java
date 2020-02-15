package model.Deck;

import model.card.Card;

/**
 * BattlePile contains the information from the card that putted from other
 * player to the battlePile
 *
 * @version 1.0
 * @author Tasos Anastasas
 */
public class BattlePile {

    private Card card = null;
    private Deck d;

    /**
     * Transformer: Setting the enemy deck
     * @param d enemy deck
     */
    public BattlePile(Deck d) {
        this.d = d;
    }

    /**
     * Transformer: change the value of variable card to the new card
     * Postcondition: card value change to new card
     *
     * @param cd the new card
     * @return true if the card added, false otherwise
     */
    public boolean AddCard(Card cd) {
        if (cd.getCardName() == "Out of Gas" && !d.isFirstTime()) {
            if (!d.isExtraTank()) {
                d.getBattlePile().setCard(cd);
                return true;
            }
        }
        if (cd.getCardName() == "Accident" && !d.isFirstTime()) {
            if (!d.isDrivingAce()) {
                d.getBattlePile().setCard(cd);
                return true;
            }
        }
        if (cd.getCardName() == "Flat Tire" && !d.isFirstTime()) {
            if (!d.isPunctureProof()) {
                d.getBattlePile().setCard(cd);
                return true;
            }
        }
        if (cd.getCardName() == "Speed Limit"){
            if (!d.isRightOfWay()) {
                d.getSpeedPile().addCard(cd);
                return true;
            }
        }
        if(cd.getCardName()== "STOP" && !d.isFirstTime()){
            if (!d.isRightOfWay()) {
                d.getBattlePile().setCard(cd);
                return true;
            }
        }
        if(cd.getCardName()=="ROLL"){
            card=cd;
            return true;
        }
        
        return false;
    }
   
    /**
     * Transformer: change the value of the card to new
     * @param cd new value
     */
    public void setCard(Card cd){
        this.card=cd;
    }
    
    /**
     * Observer: getting the card of the battlePile
     * @return value of card
     */
    public Card getCard() {
        return this.card;
    }

    /**
     * Transformer: set the card of the class to null
     */
    public void removeCard() {
        this.card = null;
    }
}
