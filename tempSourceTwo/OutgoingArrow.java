package theilluminatigame;

public class OutgoingArrow extends Arrow {

    
       protected Card OutCard;

    /**
     * Add a Card to the Arrow as long as its not a Special Card
     * So the Card can only be either an Illuminati Card or a Group Card
     * 
     * @param card
     */
    public void addCardToArrow(Card card){
	if(card instanceof SpecialCard == false){
	    this.OutCard = card;
	}
    }
    
    public void removeGroupCardFromArrow(){
	this.OutCard = null;
    }
    
    public Card getCardFromArrow(){
	return OutCard;
    }
    
}
