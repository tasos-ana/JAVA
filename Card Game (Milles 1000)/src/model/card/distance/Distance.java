package model.card.distance;

import model.card.Card;

/**
 * Distance class contains all the information for one distance card
 *
 * @author Tasos
 */
public class Distance implements Card {

    private int value = 0;
    private String cardName="";

    /**
     * Constructor: constructs a new Distance card with new value and name.
     * Postcondition: constructs a new Distance card with new value and name
     *
     * @param value card value
     */
    public Distance(int value) {
        this.cardName = "M"+Integer.toString(value);
        this.value = value;
    }

    /**
     * Accessors: return the value of the card 
     * Postcondition: return the value of the card
     *
     * @return the value of the card
     */
    public int getValue() {
        return value;
    }

    /**
     * Transformer: set new value for the card Postcondition: set new value for
     * the card
     *
     * @param value new value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Returns the string representation of a card Postcondition: The string
     * representation of a card is returned
     *
     * @return The string representation of a card
     */
    @Override
    public String toString() {
        return this.getCardType();
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
        return c instanceof Distance;
    }

    /**
     * Accessors: returns the card's name 
     * Postcondition: card's name has been returned
     * @return cardName(string)
     */
    @Override
    public String getCardName() {
        return this.cardName;
    }

    /**
     * Transformer:sets the card's name Postcondition: card's name has been set
     *
     * @param card new name
     */
    @Override
    public void setCardName(String card) {
        this.cardName = card;
    }
    
    /**
     * Accessors: returns the card's name
     * Postcondition: card's type has been returned
     * @return card name
     */
    public String getCardType(){
        return this.getCardName();
    }
}
