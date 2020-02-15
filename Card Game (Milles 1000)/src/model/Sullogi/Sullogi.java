package model.Sullogi;

import java.util.ArrayList;
import java.util.Collections;
import model.card.Card;
import model.card.distance.Distance;
import model.card.hazard.Accident;
import model.card.hazard.FlatTire;
import model.card.hazard.OutOfGas;
import model.card.hazard.SpeedLimit;
import model.card.hazard.Stop;
import model.card.remedy.EndOfLimit;
import model.card.remedy.Gasoline;
import model.card.remedy.Repairs;
import model.card.remedy.Roll;
import model.card.remedy.SpareTire;
import model.card.safety.DrivingAce;
import model.card.safety.ExtraTank;
import model.card.safety.PunctureProof;
import model.card.safety.RightOfWay;

/**
 * This class creates a new Collection of cards.
 *
 * @version 1.0
 * @author Tasos Anastasas
 */
public class Sullogi {

    private ArrayList<Card> cards;

    /**
     * Constructor.
     *
     * Postcondition:Creates a new Sullogi with a new card ArrayList.
     *
     */
    public Sullogi() {
        cards = new ArrayList<Card>();
    }

    /**
     * Transformer: Initializes and shuffles the 106 cards. Postcondition: The
     * cards have been initialised and shuffled.
     */
    public void init_cards() {
        cards.clear();
        for (int i = 0; i < 10; i++) {
            cards.add(new Distance(25));
            cards.add(new Distance(50));
            cards.add(new Distance(75));
            cards.add(new Distance(100));
        }
        cards.add(new Distance(100));
        cards.add(new Distance(100));

        cards.add(new Distance(200));
        cards.add(new Distance(200));
        cards.add(new Distance(200));
        cards.add(new Distance(200));

        cards.add(new DrivingAce());
        cards.add(new ExtraTank());
        cards.add(new PunctureProof());
        cards.add(new RightOfWay());

        for (int i = 0; i < 3; i++) {
            cards.add(new Accident());
            cards.add(new OutOfGas());
            cards.add(new FlatTire());
            cards.add(new Stop());
            cards.add(new SpeedLimit());
        }
        cards.add(new Stop());
        cards.add(new Stop());
        cards.add(new SpeedLimit());

        for (int i = 0; i < 6; i++) {
            cards.add(new Repairs());
            cards.add(new Gasoline());
            cards.add(new SpareTire());
            cards.add(new Roll());
            cards.add(new EndOfLimit());
        }

        for (int i = 0; i < 8; i++) {
            cards.add(new Roll());
        }
        Collections.shuffle(cards);
    }

    /**
     * Observer: Returns true if this list contains no elements. Postcondition:
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * Observer: Adds a card to the list. Postcondition: A card has been added
     * to the list.
     *
     * @param cd new card
     */
    public void addCard(Card cd) {
        this.cards.add(cd);
    }

    /**
     * Accessors: returns the card's value in position target Postcondition:
     * card's value in position target has been returned
     *
     * @param target the card location
     * @return the value of the card in position target if the card is a
     * Distance instance
     */
    public int getValue(int target) {
        if (cards.get(target).match(new Distance(50))) {
            return ((Distance) cards.get(target)).getValue();
        } else {
            return -1;
        }
    }

    /**
     * Transformer: Removes a card from the list. Postcondition: A card has been
     * removed from the list.
     *
     * @param cd
     */
    public void removeCard(Card cd) {
        cards.remove(cd);
        cards.trimToSize();
    }

    /**
     * Transformer: Returns the size of a list. Postcondition: The size of the
     * list has been returned.
     *
     * @return size of the list
     */
    public int size() {
        return cards.size();
    }

    /**
     * Accessors: returns the card in position 'target' Postcondition: the card
     * in position 'target' has been returned
     *
     * @param target the card location
     * @return the card in position 'target'
     */
    public Card getCard(int target) {
        return cards.get(target);
    }

    /**
     * Transformer: Clears an ArrayList Postcondition: An ArrayList is cleared.
     */
    public void clearAll() {
        this.cards.clear();
    }

    /**
     * Accessors: returns all the cards Postcondition: all the cards has been
     * returned
     *
     * @return all the cards
     */
    public ArrayList<Card> getCards() {
        return this.cards;
    }
}
