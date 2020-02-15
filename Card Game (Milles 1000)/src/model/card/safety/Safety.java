package model.card.safety;

import model.card.Card;

/**
 * Safety class contains all the information for on Safety card
 * @version 1.0
 * @author Tasos Anastasas
 */
public abstract class Safety implements Card {
    
    private String type;
    private String cardName;

/**
     * Constructor: constructs a new Safety card with new cardName and type
     * Postcondition: constructs a new Safety card with new cardName and type
     * @param cardName name of the card
     * @param type type of the card
     */
    public Safety(String cardName, String type) {
        this.type = type;
        this.cardName = cardName;
    }

    /**
     * Accessors: return the name of the card
     * Postcondition: return the name of the card
     * @return the name of the card
     */
    @Override
    public String getCardName() {
        return cardName;
    }

    /**
     * Transformer: set new name for the card
     * Postcondition: set new name for the card
     * @param cardName new name
     */
    @Override
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    /**
     * Accessors: return the type of the card
     * Postcondition: return the type of the card
     * @return the type of the card
     */
    public String getType() {
        return type;
    }

    /**
     * Transformer: set new type for the card
     * Postcondition: set new type for the card
     * @param type new type
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * Returns the string representation of a card
     * Postcondition: The string representation of a card is returned
     * @return The string representation of a card 
     */
    @Override
    public String toString(){
        return this.getType();
    }
}
