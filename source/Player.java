package theilluminatigame;
import java.util.ArrayList;

/** Player is a representation of player */

public class Player {

	private String name;
    private Illuminati illuminati;
    private int diceRollOutcome;
    private int actionsTaken;
    private int freeActionsTaken;

    private ArrayList<SpecialCard> specialCards;
    private boolean interfereFlag;

    public Player() {
	diceRollOutcome = 0;
	actionsTaken = 0;
	specialCards = new ArrayList<SpecialCard>();
	interfereFlag = false;
    }

    public Player(Illuminati illuminati) {
	this.illuminati = illuminati;
	diceRollOutcome = 0;
	actionsTaken = 0;
	specialCards = new ArrayList<SpecialCard>();
	interfereFlag = false;
    }

    public void setIlluminati(Illuminati illuminati) {
	this.illuminati = illuminati;
    }

    public Illuminati getIlluminati() {
	return this.illuminati;
    }

    public void addSpecialCard(SpecialCard specialCard) {
	specialCards.add(specialCard);
    }

    public void useSpecialCard(int choice) {
	specialCards.get(choice).useSpecialCardEffect();
    }

    // Roll dice value from 2 to 12
    public void rollDie() {

	int highestRange = 12;
	int lowestRange = 2;
	diceRollOutcome = (int) (Math.random() * highestRange) + lowestRange;

    }

    // For easy and fast testing, we can set the dice roll value
    public void setDiceRoll_TestModeOnly(int value){
    	diceRollOutcome = value;
    }
    
    public int getDiceRollOutcome() {
	return diceRollOutcome;
    }

    public int getActionsTaken() {
	return actionsTaken;
    }

    public int getFreeActionsTaken() {
    	return freeActionsTaken;
        }
    
    public void takeAction() {
	actionsTaken++;
    }
    
    public void takeFreeAction() {
    	freeActionsTaken++;
        }

    /**
     * After the player is done with his turn, then his number of actions taken
     * is set back to 0
     */
    public void resetAction() {
    	actionsTaken = 0;
    	freeActionsTaken = 0;
    }

    /** Player interferes an attack */
    public void interfere() {
	interfereFlag = true;
    }

    /**
     * After the player is done with his turn, then his interference is set back
     * to false
     */
    public void resetInterfere() {
	interfereFlag = false;
    }
    
    /**
     * Reset player's dice roll value after he is done attacking
     */
    public void resetDiceValue(){
    	this.diceRollOutcome = 0;
    }

    /**
     * Remove this method since the power structured should be already be
     * displayed via the gameUI class 
     * 
     * */
     //Actually let's put this method back for now 
     public void displayPowerStructure(){
    	 System.out.println("200 Displaying Power Structure Method is called");
    	 
    	// this.getIlluminati().
     }

}
