package model.card;

/**
 * Contains the methods signatures needed for 
 * creating a card for the game
 * @version 1.0
 * @author Tasos Anastasas
 */
public abstract interface Card {
    
    /**
     * Accessors: returns the card's name
     * Postcondition: card's name has been returned
     * @return String value
     */
    public String getCardName();
    
    /**
     * Transformer:sets the card's name
     * Postcondition: card's name has been set
     * @param card new name
     */
    public void setCardName(String card);

    /**
     * Observer: Return if the card C match with the instance that called
     * Postcondition: card C has been set
     * @param c card 
     * @return Return if the card C match with the instance that called
     */
    public abstract boolean match(Card c);
    
    /**
     * Returns the string representation of a card
     * Postcondition: The string representation of a card is returned
     * @return The string representation of a card 
     */
    @Override
    public String toString();
}
