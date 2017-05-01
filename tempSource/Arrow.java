package theilluminatigame;


public class Arrow {


  
  
    
       protected Card card;

    /**
     * Add a Card to the Arrow as long as its not a Special Card
     * So the Card can only be either an Illuminati Card or a Group Card
     * 
     * @param card
     */
    public void addCardToArrow(Card card){
	if(card instanceof SpecialCard == false){
	    this.card = card;
	}
    }
    
    public void removeGroupCardFromArrow(){
	this.card = null;
    }
    
    public Card getCardFromArrow(){
	return card;
    }

}
