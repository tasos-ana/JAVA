package model.Deck;

import model.Sullogi.Sullogi;
import model.card.Card;
import model.card.distance.Distance;

/**
 * DistancePile contains the information from the card that put the player on
 * his deck
 *
 * @version 1.0
 * @author Tasos Anastasas
 */
public class DistancePile {

    private Sullogi card;
    private Deck d;
    private int totalMilles;
    private int counter;

    public DistancePile(Deck d) {
        this.d = d;
        card = new Sullogi();
        totalMilles = 0;
        counter = 0;
    }

    /**
     * Transformer: add new card to the card Collection Postcondition: at
     * collection added the card cd
     *
     * @param cd the new card
     * @return if the card can added
     */
    public boolean addCard(Card cd) {
        int cardValue = ((Distance) cd).getValue();
        if (totalMilles + cardValue <= 1000) {
            if (CanMove()) {
                //an uparxei orio kai einai h card<=50 tin vazei
                if (isSpeedLimited()) {
                    if (cardValue <= 50) {
                        card.addCard(cd);
                        totalMilles = totalMilles + cardValue;
                        return true;
                    }
                }//An dn uparxei orio elegxei to value 
                else {
                    if (cardValue == 200) {
                        if (counter < 2) {
                            card.addCard(cd);
                            totalMilles = totalMilles + cardValue;
                            counter++;
                            return true;
                        }
                    }
                    card.addCard(cd);
                    totalMilles = totalMilles + cardValue;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Observer: return true if the player can move(if can add a distance card
     * to the deck),false otherwise. Postcondition: return true if the player
     * can move(if can add a distance card to the deck),false otherwise
     *
     * @return true if the player can move(if can add a distance card to the
     * deck),false otherwise
     */
    public boolean CanMove() {
        if (d.getBattlePile().getCard() != null) {
            if (d.getBattlePile().getCard().getCardName() == "ROLL") {
                return true;
            }
        } else {
            Sullogi safe = d.getSafetyPile().getAllCard();
            for (int i = 0; i < safe.size(); i++) {
                if (safe.getCard(i).getCardName() == "Right of Way") {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Observer: return true if there is any speed limit for that deck,false
     * otherwise Postcondition:return true if there is any speed limit for that
     * deck,false otherwise
     *
     * @return true if there is any speed limit for that deck,false otherwise
     */
    public boolean isSpeedLimited() {
        if (d.getSpeedPile().getCard() == null) {
            return false;
        }
        return d.getSpeedPile().getCard().getCardName() == "Speed Limit";
    }

    /**
     * Observer: return true if the player reach the 1000miles, false otherwise
     * Postcondition: return true if the player reach the 1000miles, false
     * otherwise
     * @return true if the player reach the 1000miles, false otherwise
     */
    public boolean isTheWinner() {
        return totalMilles == 1000;
    }

    /**
     * Observer: Returning the total miles
     * @return totalMilles
     */
    public int getTotalMilles() {
        return totalMilles;
    }

    /**
     * Accessors: returning the last card of Array if it's not empty
     * @return last card
     */
    public Card getLastCard() {
        if (card.isEmpty()) {
            return null;
        }
        return card.getCard(card.size() - 1);
    }
}
