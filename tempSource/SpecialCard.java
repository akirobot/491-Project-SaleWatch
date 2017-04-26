package theilluminatigame;

import javax.swing.ImageIcon;

// Have to remove abstract because you can't instantiate Special Cards in main
public class SpecialCard extends Card {

    
    public SpecialCard(String name, int type, ImageIcon face){
	super(name, type, face);
    }
    
    public void useSpecialCardEffect() {
	if(this.getCardName() == "Murphy's Law"){
	    
	}else if(this.getCardName() == "Assassination"){
	    
	}
    }
    
}
