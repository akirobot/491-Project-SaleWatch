
public class Card {

    private String name;
    /**
     * Types of Card
     * (1): Illuminati Card
     * (2): Special Card
     * (3): Group Card
     */
    private int type;
    
    public Card(String name, int type){
	this.name = name;
	this.type = type;
	
	if(type == 1){
	    System.out.println("This is an Illuminati card");
	}
	
	if(type == 2){
	    System.out.println("This is a Special card");
	}
	
	if(type == 3){
	    System.out.println("This is a Group card");
	}
    }
    
    public Card(String name, int income, int power, int transferPower, int resistance, int type){
	
    }
    
    public String getCardName(){
	return name;
    }
}
