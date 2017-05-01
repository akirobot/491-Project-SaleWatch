package theilluminatigame;

public class IncomingArrow extends Arrow {
   protected Card InCard;

    /**
     * Add a Card to the Arrow as long as its not a Special Card
     * So the Card can only be either an Illuminati Card or a Group Card
     * 
     * @param card
     */
    public void addCardToArrow(Card card){
	if(card instanceof SpecialCard == false){
	    this.InCard = card;
	}
    }
    
    public void removeGroupCardFromArrow(){
	this.InCard = null;
    }
    
    public Card getCardFromArrow(){
	return InCard;
    }
}
