import java.util.ArrayList;

public abstract class Illuminati extends CombatCard implements Attack {

    private ArrayList<Group> puppets = new ArrayList<Group>();
    private final static int outgoingArrows = 4; 

    private Arrow top = new OutgoingArrow();
    private Arrow bottom = new OutgoingArrow();
    private Arrow left = new OutgoingArrow();
    private Arrow right = new OutgoingArrow();
    
    public Illuminati(String name, int income, int power, int tPower) {
	super(name, income, power, tPower, outgoingArrows);
	// TODO Auto-generated constructor stub
    }
    
    /*
     * An Illuminati has a max of 4 direct puppets. 
     */
    public Group getIlluminatiPuppet(int choice){
	if((choice > outgoingArrows) && (choice < 0)){
	    // invalid choice
	}
	return null;
    }
 
    public void displayPuppets(){
	
    }
    
    public abstract void useSpecialPowerActions();

}
