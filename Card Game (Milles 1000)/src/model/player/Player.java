package model.player;

import model.Sullogi.Sullogi;
import model.card.Card;

/**
 * Player class describes the characteristics of a player and provides
 * modification methods.
 *
 * @version 1.0
 * @author Tasos Anastasas
 */
public class Player {

    private String name;
    private Sullogi cards;
    private int ID;

    /**
     * constructor: Constructs a new Player with the given parameter name and
     * ID. postcondition: Creates and initializes a player with the given
     * name,and ID.Also initializes some variables (for example initialize
     * variables that give us information if player has started or finished in a
     * game
     *
     * @param name is the name of the player.
     * @param ID is the ID of the player
     */
    public Player(String name, int ID) {
        this.name = name;
        this.ID = ID;
        this.cards = new Sullogi();
    }

    /**
     * accessors:Returns the name of the player Postcondition:returns the name
     * of the player
     *
     * @return the the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * accessors :Returns the cards that player have on his hands Postcondition:
     * returns the cards that player have on his hands
     *
     * @return the cards that player have on his hands
     */
    public Sullogi getCards() {
        return cards;
    }

    /**
     * transformer: adds a Card to players cards Postcondition: a card added to
     * players cards
     *
     * @param cards the card that will be added to players Sullogi
     *
     */
    public void setCards(Sullogi cards) {
        this.cards = cards;
    }

    /**
     * Observer: return if the card with (type):type founded and removed successful
     * @param type card type
     * @return true if the card founded and removed,false otherwise.
     */
    public Card removeCard(String type) {
        Card temp=null;
        for (int i = 0; i < cards.size(); i++) {
            if(cards.getCard(i).toString()==type){
                temp=cards.getCard(i);
                cards.removeCard(cards.getCard(i));    
            }
        }
        return temp;
    }

    /**
     * accessors: Returns the ID of a player. postcondition: Returns the ID of
     * the player.
     *
     * @return the ID of the player (int)
     */
    public int getID() {
        return ID;
    }

    /**
     * transformer: It sets the ID of a player postcondition:the ID of the
     * player is changed to id
     *
     * @param ID the new ID of the player
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Observer: return if the card with type exist on player cards
     * @param type card type
     * @return the card if exist,null otherwise
     */
    public Card getCard(String type){
        for(int i=0;i<cards.size();i++){
            if(cards.getCard(i).toString()==type){
                return cards.getCard(i);
            }
        }
        return null;
    }
}
