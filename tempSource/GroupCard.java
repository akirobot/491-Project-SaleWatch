package theilluminatigame;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class GroupCard extends Card implements Attack, cardStats,
	cardUpdateStats {

    private Card master;
    private Illuminati illuminati;
    private ArrayList<GroupCard> puppets = new ArrayList<GroupCard>();
    private ArrayList<String> alignments = new ArrayList<String>();

    // Non-default values
    // These values change during the course of the game
    private int treasury;
    private int income;
    private int power;
    private int resistance;
    private int transferrablePower;
    
    // Default values
    // These values should not change during the course of the game, besides the initial assignment
    private int incomeDefault;
    private int powerDefault;
    private int transferrablePowerDefault;
    private int resistanceDefault;



    private Arrow top;
    private Arrow bottom;
    private Arrow left;
    private Arrow right;

    public GroupCard(String name, int type, int power, int tPower,
	    int resistance, int income, ImageIcon face) {
	super(name, type, power, tPower, resistance, income, face);
		
		incomeDefault = income;
		powerDefault = power;
	    transferrablePowerDefault = tPower;
	    resistanceDefault = resistance;
    }

    public void setTopArrow(Arrow direction) {
	top = direction;
    }

    public void setBottomArrow(Arrow direction) {
	bottom = direction;
    }

    public void setLeftArrow(Arrow direction) {
	left = direction;
    }

    public void setRightArrow(Arrow direction) {
	right = direction;
    }

    public Card getMaster() {
	return master;
    }

    public GroupCard getPuppet(int choice) {
	return puppets.get(choice);
    }

    public void setMaster(Card master) {
	this.master = master;
    }

    public void setIlluminati(Illuminati illuminati) {
	this.illuminati = illuminati;
    }

    public void addPuppet(GroupCard puppet) {
	puppets.add(puppet);
    }

    public void addAlignment(String alignment) {
	alignments.add(alignment);
    }

    @Override
    public void adjustTreasury(int megaBucks) {
	// TODO Auto-generated method stub
    	this.treasury += megaBucks;
    }

    @Override
    public void adjustPower(int power) {
	// TODO Auto-generated method stub
    	this.power += power;
    }

    @Override
    public void adjustTransferrablePower(int tPower) {
	// TODO Auto-generated method stub
    	this.transferrablePower += tPower;
    }

    @Override
    public int getIncome() {
	// TODO Auto-generated method stub
	return income;
    }

    @Override
    public int getTreasury() {
	// TODO Auto-generated method stub
	return treasury;
    }

    @Override
    public int getPower() {
	// TODO Auto-generated method stub
	return power;
    }

    @Override
    public int getTransferrablePower() {
	// TODO Auto-generated method stub
	return transferrablePower;
    }
    
    // Maybe income stays consistent instead of changing values throughout the game
    public int getIncomeDefault(){
    	return incomeDefault;
  
    }
    
    public int getPowerDefault(){
     
    	return powerDefault;
    }
    
    public int getTansferrablePowerDefault(){
        return transferrablePowerDefault;
    }
    
    public int getResistanceDefault(){
    
    	 return resistanceDefault;
    }
    
    /**
     * Let's say a Group Card was controlled, then neutralized back to the UncontrolledArea.
     * Then we want to reset its power, tPower, and resistance back to its default value.
     */
    public void resetAllAttributesToDefault(){
    	
        income = incomeDefault;
        power = powerDefault;
        resistance = resistanceDefault;
        transferrablePower = transferrablePowerDefault;
       
    }
    
    /**
     * Show power, tPower, treasury, and resistance
     */
    public void displayStats(){
    	// this.getCardName();
    	System.out.println("103 Display Stats for " + this.getCardName());

    	System.out.println("\t Power: " + this.getPower());
    	System.out.println("\t tPower: " + this.getTransferPower());
    	System.out.println("\t tPower: " + this.getResistance());
    	System.out.println("\t treasury: " + this.getTreasury());
    	System.out.println("\t income: " + this.getIncome());



    	
    }

    @Override
    public void attackToControl(Card attacker, GroupCard defender) {
	// TODO Auto-generated method stub

    }

    @Override
    public void attackToDestroy(Card attacker, GroupCard defender) {
	// TODO Auto-generated method stub

    }

    @Override
    public void attackToNeutralize(Card attacker, GroupCard defender) {
	// TODO Auto-generated method stub

    }
}
