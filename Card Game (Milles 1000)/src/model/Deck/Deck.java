package model.Deck;

import model.Sullogi.Sullogi;
import model.card.Card;
import model.player.Player;

/**
 * Deck is the class that simulate the deck for each player
 *
 * @version 1.0
 * @author Tasos Anastasas
 */
public class Deck {

    private boolean canStart;
    private boolean firstTime = true;
    private Player p;
    private static Sullogi DrawPile = new Sullogi();
    private static Sullogi DiscardPile = new Sullogi();
    private DistancePile distanceP;
    private BattlePile battleP;
    private SafetyPile safetyP;
    private SpeedPile speedP;
    private boolean drivingAce, extraTank, punctureProof, rightOfWay;

    /**
     * Constructor: Construct a new deck and set the new player,new pilles for
     * the player and set some variables. Postcondition: Construct a new
     * deck,new player,new instance of pilles and set some variables.
     *
     * @param num number of the player
     */
    public Deck(int num) {
        p = new Player("Player " + num, num);
        canStart = false;
        distanceP = new DistancePile(this);
        safetyP = new SafetyPile(this);
        speedP=new SpeedPile(this);
        drivingAce = false;
        extraTank = false;
        punctureProof = false;
        rightOfWay = false;
    }

    /**
     * Transformer: set on that deck the enemy deck
     * @param d enemy deck
     */
    public void setBattlePileDeck(Deck d) {
        battleP = new BattlePile(d);
    }
    
    /**
     * Observer: return true if the player never play for that game,false
     * otherwise Postcondition:return true if the player never play for that
     * game,false otherwise
     * @return firstTime
     */
    public boolean isFirstTime() {
        return this.firstTime;
    }

    /**
     * Transformer: set new value on the firstTime
     * @param x new boolean value
     */
    public void setFirstTime(boolean x) {
        this.firstTime = x;
    }

    /**
     * Observer: return true if that player reach 1000milles and win the game,
     * else false Postcondition:return true if that player reach 1000milles and
     * win the game, else false
     *
     * @return win
     */
    public boolean isWinner() {
        return distanceP.isTheWinner();
    }

    /**
     * Observer: return the player of the current deck Postcondition: return the
     * p that contain an instance of Player
     *
     * @return p
     */
    public Player getPlayer() {
        return p;
    }

    /**
     * Observer: Return true if drawPile contains no elements,false otherwise.
     * Postconditions: Return true if drawPile contains no elements,false
     * otherwise.
     *
     * @return Return true if drawPile contains no elements,false otherwise.
     */
    public boolean isEmptyDrawPile() {
        return DrawPile.isEmpty();
    }

    /**
     * Observer: get new card from the drawPile Postcondition: returning the
     * last card from drawPile
     *
     * @return last card from drawPile
     */
    public static Card popDrawPile() {
        Card temp = null;
        if (!DrawPile.isEmpty()) {
            temp = DrawPile.getCard(DrawPile.size() - 1);
            DrawPile.removeCard(temp);
        }
        return temp;

    }

    /**
     * Transformer: adding a Card to the discardPile Postcondition: adding a
     * Card to the discardPile
     *
     * @param cd card
     */
    public static void pushDiscardPile(Card cd) {
        DiscardPile.addCard(cd);
    }

    /**
     * Observer: getting the 7th card for the player Postcondition: drawPille
     * cant be empty
     * @return tempCard
     */
    public Card getTempCard() {
        return popDrawPile();
    }

    /**
     * Transformer: adding a Card to the distancePile Postcondition: adding a
     * Card to the distancePile
     *
     * @param cd card
     * @return if the carded added successful
     */
    public boolean pushDistancePile(Card cd) {
        return distanceP.addCard(cd);
    }

    /**
     * Transformer: adding a Card to the battlePile Postcondition: adding a Card
     * to the battlePile
     * @param cd card
     * @return if the carded added successful
     */
    public boolean pushBattlePile(Card cd) {
        return battleP.AddCard(cd);
    }

    /**
     * Transformer: adding a Card to the safetyPile Postcondition: adding a Card
     * to the safetyPile
     * @param cd card
     * @return if the carded added successful
     */
    public boolean pushSafetyPile(Card cd) {
        switch (cd.getCardName()) {
            case "Driving Ace":
                this.setDrivingAce(true);
                break;
            case "Extra Tank":
                this.setExtraTank(true);
                break;
            case "Puncture Proof":
                this.setPunctureProof(true);
                break;
            default:
                this.setRightOfWay(true);
                break;
        }
        return safetyP.addCard(cd);
    }

    /**
     * Transformer: adding a Card to the speedPile Postcondition: adding a Card
     * to the speedPile
     * @param cd card
     * @return if the carded added successful
     */
    public boolean pushSpeedPile(Card cd) {
        return speedP.addCard(cd);
    }

    /**
     * Transformer: setting new value on variable drivingAce
     * @param drivingAce new value
     */
    public void setDrivingAce(boolean drivingAce) {
        this.drivingAce = drivingAce;
    }

    /**
     * Transformer: setting new value on variable extraTank
     * @param extraTank new value
     */
    public void setExtraTank(boolean extraTank) {
        this.extraTank = extraTank;
    }

    /**
     * Transformer: setting new value on variable punctureProof
     * @param punctureProof new value
     */
    public void setPunctureProof(boolean punctureProof) {
        this.punctureProof = punctureProof;
    }

    /**
     * Transformer: setting new value on variable rightOfWay
     * @param rightOfWay new value
     */
    public void setRightOfWay(boolean rightOfWay) {
        this.rightOfWay = rightOfWay;
    }

    /**
     * Observer: getting the distance Pile
     * @return distanceP
     */
    public DistancePile getDistancePile() {
        return distanceP;
    }

    /**
     * Observer: getting the battle Pile
     * @return battleP
     */
    public BattlePile getBattlePile() {
        return battleP;
    }

    /**
     * Observer: getting the safety Pile
     * @return safetyP
     */
    public SafetyPile getSafetyPile() {
        return safetyP;
    }

    /**
     * Observer: getting the Speed Pile
     * @return speedP
     */
    public SpeedPile getSpeedPile() {
        return speedP;
    }

    /**
     * Observer: getting the draw pile
     * @return DrawPile
     */
    public Sullogi getDrawPile() {
        return DrawPile;
    }

    /**
     * Observer: returning the driving ace value
     * @return drivingAce
     */
    public boolean isDrivingAce() {
        return drivingAce;
    }

    /**
     * Observer: returning the extra tank value
     * @return extraTank
     */
    public boolean isExtraTank() {
        return extraTank;
    }

    /**
     * Observer: returning the puncture proof value
     * @return punctureProof
     */
    public boolean isPunctureProof() {
        return punctureProof;
    }

    /**
     * Observer: returning the right of the way value
     * @return rightOfWay
     */
    public boolean isRightOfWay() {
        return rightOfWay;
    }

}
