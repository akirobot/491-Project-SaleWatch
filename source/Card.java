/** Card is a representation of card */

public class Card {

    /** The name of this card */
    private String name;

    /**
     * The type of this card. Types of Card (1): Illuminati Card (2): Group Card
     * (3): Special Card
     */
    private int type;

    /**
     * Special Card constructor
     * 
     * @param name
     * @param type - Must be type 3
     */
    public Card(String name, int type) {
	this.name = name;
	this.type = type;
    }

    /**
     * Illuminati Card constructor - An Illuminati Card does not have any
     * resistances
     * 
     * @param name
     * @param type - Must be type 1
     * @param income
     * @param power
     * @param transferPower
     */
    public Card(String name, int type, int power, int transferPower, int income) {

    }

    /**
     * Group Card constructor
     * 
     * @param name
     * @param type - Must be type 2
     * @param income
     * @param power
     * @param transferPower
     * @param resistance
     */
    public Card(String name, int type, int power, int transferPower,
	    int resistance, int income) {

    }

    public String getCardName() {
	return name;
    }

    public int getCardType() {

	if (type == 1) {
	    System.out.println("This is an Illuminati card");
	}

	if (type == 2) {
	    System.out.println("This is a Group card");
	}

	if (type == 3) {
	    System.out.println("This is a Special card");
	}

	return type;
    }
}
