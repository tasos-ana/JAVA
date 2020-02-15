package controller;

import model.Deck.Deck;
import model.Sullogi.Sullogi;
import model.card.Card;
import model.card.distance.Distance;
import model.card.hazard.Accident;
import model.card.remedy.Roll;
import model.card.safety.DrivingAce;
import model.player.Player;
import model.turn.Turn;

/**
 * Controller is the master of the game and controls all of the operations
 * executed
 *
 * @version 1.0
 * @author Tasos Anastasas
 */
public class Controller {

    private Deck d1;
    private Deck d2;
    private Player p1;
    private Player p2;
    private Turn turn;

    /**
     * constructor: Constructs a new Controller and sets the game details .
     * postcondition: constructs a new Controller,with new 2 players,new 2 decks
     * new instance of turn class.
     */
    public Controller() {
        d1 = new Deck(1);
        d2 = new Deck(2);
        d1.setBattlePileDeck(d2);
        d2.setBattlePileDeck(d1);
        p1 = d1.getPlayer();
        p2 = d2.getPlayer();
        d1.getDrawPile().init_cards();
        turn = new Turn();
    }

    /**
     * Transformer: take an card as input, the card that player want to play.
     * Checking if that card match and can be played. Postcondition: set the
     * cardValid to true if the card can played,otherwise false.
     *
     * @param cd the card that player wants to play
     * @param p the player that playing the card
     * @return true if card can played, else false
     */
    public boolean PlayCard(Card cd, Player p) {
        boolean added = false;
        int playAgain;
        Deck curD;
        if (p == p1) {
            curD = d1;
            playAgain = 2;
        } else {
            curD = d2;
            playAgain = 1;
        }
        if (cd.match(new DrivingAce())) {
            added = curD.pushSafetyPile(cd);
            if (added) {
                this.turn.setID(playAgain);
                if (curD.isRightOfWay()) {
                    curD.setFirstTime(false);
                    return true;
                }    
            }
        } else if (cd.match(new Accident()) && (cd.getCardName() == "Speed Limit")) {
            added = curD.pushBattlePile(cd);
        } else if (cd.match(new Roll()) && cd.getCardName() == "ROLL") {
            added = curD.pushSpeedPile(cd);
            if (added) {
                curD.setFirstTime(false);
                return true;
            }
        }
        if (!curD.isFirstTime()) {
            if (cd.match(new Distance(5))) {
                added = curD.pushDistancePile(cd);
            } else if (cd.match(new Accident())) {
                added = curD.pushBattlePile(cd);
            } else if (cd.match(new Roll())) {
                added = curD.pushSpeedPile(cd);
            }
        }
        return added;

    }
    
    /**
     * Observer: Found and delete the card with type:type from the player card
     * @param type the card that we want to remove.
     */
    public void DiscardCard(String type) {
        if (this.seeTurn() == 1) {
            Deck.pushDiscardPile(p1.removeCard(type));
        } else {
            Deck.pushDiscardPile(p2.removeCard(type));
        }
    }

    /**
     * accessors: return the temp card that some1 player get from the drawPille
     * @return the temp card
     */
    public Card getTempCard() {
        Card x = Deck.popDrawPile();
        if (x != null) {
            return x;
        } else {
            return null;
        }
    }

    /**
     * transformer: we sharing 6 card from the 106 to the player
     */
    public void shareCards() {
        Sullogi playersCards1 = new Sullogi();
        Sullogi playersCards2 = new Sullogi();
        for (int i = 0; i < 6; i++) {
            playersCards1.addCard(Deck.popDrawPile());
            playersCards2.addCard(Deck.popDrawPile());
        }
        p1.setCards(playersCards1);
        p2.setCards(playersCards2);
    }

    /**
     * accessors:Returns which player has the turn Postcondition: Returns which
     * player has the turn
     * @return which player has the turn (for example 0 if p1 has the turn )
     */
    public int seeTurn() {
        return turn.getID();
    }

    /**
     * Transformer: set new Id on the Turn, depends on previous id
     */
    public void nextPlayer() {
        if (turn.getID() == 1) {
            turn.setID(2);
        } else {
            turn.setID(1);
        }
    }

    /**
     * Observer:Return true if a game(a player reaches 1000 miles) has finished or no more cards to play,
     * false otherwise 
     * Postcondition: return true if a game(a player reaches 1000 miles) has finished or no more cards to play,
     * false otherwise 
     * @return true if a game(a player reaches 1000 miles) has finished, false
     * otherwise
     */
    public boolean game_has_finished() {
        if(d1.getPlayer().getCards().isEmpty() && d2.getPlayer().getCards().isEmpty()){
            return true;
        }else if(d1.isWinner() || d2.isWinner()){
            return true;
        }else{
            return false;
        }
        
    }

    /**
     * Accessors: getting the total Miles of the player1
     * @return player 1 total miles
     */
    public int p1Milles() {
        return d1.getDistancePile().getTotalMilles();
    }

    /**
     * Accessors: getting the total Miles of the player 2
     * @return player 2 total miles
     */
    public int p2Milles() {
        return d2.getDistancePile().getTotalMilles();
    }

    /**
     * Accessors: getting the Deck 1
     * @return deck 1
     */
    public Deck getDeck1() {
        return d1;
    }

    /**
     * Accessors: getting the Deck 2
     * @return deck 2
     */
    public Deck getDeck2() {
        return d2;
    }
}
