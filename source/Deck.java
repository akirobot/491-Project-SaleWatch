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
    public Deck(){s
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
    
    /* Remove this method, since it's not needed
    public void displayAllCards(){
	
    }
    */
}

