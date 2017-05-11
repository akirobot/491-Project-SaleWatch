package theilluminatigame;
import java.util.ArrayList;
import java.util.Collections;


/**
Deck is an abstract representation of Deck
*/
public class Deck {

    // Private member called deck, which is an ArrayList that takes in a Card object
    // Group Cards, Special Cards are subclasses of Cards, so they can go inside deck.

    private ArrayList<Card> deck;
   
    // Default constructor
    public Deck(){
	   deck = new ArrayList<Card>();
    }
    
    // Add card to deck 
    public void addCards(Card card){
	   deck.add(card);
    }

    // Shuffle the deck
    public void shuffleDeck(){
        Collections.shuffle(this.deck);
    }
    

    /**
     * Draw card from top of deck
     * Decrease size of Deck by 1 by removing the card drawn
     * Only draw if there is at least 1 card left. Use getDeckSize in Game.java to check if the gameDeck's size is greater than 1
     * @return Card that was at the top of the face-down deck
     */
    public Card draw(){
        
    	int topOfDeckIndex = deck.size() - 1;
    	Card cardDrawn = deck.get(topOfDeckIndex);
        deck.remove(deck.get(topOfDeckIndex));
    	return cardDrawn;
        
    }
    
    public int getDeckSize(){
        return deck.size();
    }
    
  
    
    
     //temp method 
    public void displayAllCards(){
    	//System.out.println("101 deck.size() is " + deck.size());
    	for(int i = 0; i < deck.size(); i++){
    		if(deck.get(i) != null){
    			System.out.println("\t" + i + ": " + deck.get(i).getCardName());
    		}
    	}
    }
    
}

