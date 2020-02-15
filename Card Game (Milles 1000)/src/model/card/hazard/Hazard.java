package model.card.hazard;

import model.card.Card;

/**
 * Hazard class contains all the information for on hazard card (accident,out of gas .... )
 * @version 1.0
 * @author Tasos Anastasas
 */
public abstract class Hazard implements Card{
    
    private String cardName;
    private String type;

    /**
     * Constructor: constructs a new Hazard card with new cardName and type
     * Postcondition: constructs a new Hazard card with new cardName and type
     * @param cardName name of the card
     * @param type type of the card
     */
    public Hazard(String cardName,String type) {
        this.cardName = cardName;
        this.type=type;
    }
    
    /**
     * Constructor: constructs a new Hazard card with new cardName
     * Postcondition: constructs a new Hazard card with new cardName, type are the same with name
     * @param cardNameType name of the card
     */
    public Hazard(String cardNameType){
        this.cardName=cardNameType;
        this.type=cardNameType;
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
     * Returns the string representation of a card
     * Postcondition: The string representation of a card is returned
     * @return The string representation of a card 
     */
    @Override
    public String toString(){
        return this.getType();
    }
    
}
