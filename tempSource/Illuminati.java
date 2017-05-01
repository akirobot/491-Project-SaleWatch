/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theilluminatigame;

/**
 *
 * @author saidz
 */
import java.util.ArrayList;


//4.26.17 7:35 am: Have to remove abstract because you can't instantiate Illuminati Cards in main

public class Illuminati extends Card implements Attack, cardStats, cardUpdateStats {
    private ArrayList<GroupCard> puppets = new ArrayList<GroupCard>();
    private final static int outgoingArrows = 4;
    private int income;
    private int treasury;
    private int power;
    private int transferrablePower;
    private Arrow top = new OutgoingArrow();
    private Arrow bottom = new OutgoingArrow();
    private Arrow left = new OutgoingArrow();
    private Arrow right = new OutgoingArrow();
    
    private Card master = null;
    
    // Default values
    // These values should not change during the course of the game, besides the initial assignment
    private int incomeDefault;
    private int powerDefault;
    private int transferrablePowerDefault;
    
    

    
    
    public Illuminati(String name, int type, int power, int tPower, int income,javax.swing.ImageIcon face) {
	super(name, type, power, tPower, income,face);
    }
    /*
     * An Illuminati has a max of 4 direct puppets, and an unlimited amount of indirect puppets 
     */
    public GroupCard getIlluminatiPuppet(int choice) {
	if ((choice > outgoingArrows) && (choice < 0)) {
	    // invalid choice
	}
	return null;
    }
    
    public void addIncomeAtStartOfTurn() {
	 this.treasury += this.income;
    }
    
    public void moveMegaBucks() {
    }
    
    public void movePuppets() {
    }
    
    public void useSpecialPowerActions(){
	if(this.getCardName() == "The Bavarian Illuminati"){
            }else if(this.getCardName() == "The Bermuda Triangle"){
	}
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
		this.transferrablePower += tPower;
    
	}
	@Override
	public int getTreasury() {
		// TODO Auto-generated method stub
		return treasury;
	}
	@Override
	public int getTransferrablePower() {
		// TODO Auto-generated method stub
		return transferrablePower;
	}
	
	 public int getIncomeDefault(){
	    	return incomeDefault;
	  
	    }
	    
	    public int getPowerDefault(){
	     
	    	return powerDefault;
	    }
	    
	    public int getTansferrablePowerDefault(){
	        return transferrablePowerDefault;
	    }
	    
	    
	    public void resetAllAttributesToDefault(){
	    	
	        income = incomeDefault;
	        power = powerDefault;
	        transferrablePower = transferrablePowerDefault;
	       
	    }
	    
	    /**
	     * Show power, tPower, treasury, etc.
	     */
	    public void displayStats(){
	    	// this.getCardName();
	    	System.out.println("102 Display Stats for " + this.getCardName());

	    	System.out.println("\t Power: " + this.getPower());
	    	System.out.println("\t tPower: " + this.getTransferPower());
	    	System.out.println("\t treasury: " + this.getTreasury());
	    	System.out.println("\t income: " + this.getIncome());



	    	
	    }
	    
	    public void addPuppet(GroupCard puppet) {
	    	puppets.add(puppet);
	        }
	    
	
	
	@Override
	public void attackToControl(Card attacker, GroupCard defender) {
		// TODO Auto-generated method stub
		
	}
	/**Probably have to remove these interface methods and use them in the game logic instead.
	 * Attack to Destroy
	 * Power vs Power
	 */
	@Override
	public void attackToDestroy(Card attacker, GroupCard defender) {
		// TODO Auto-generated method stub
		if((attacker.getPower() - defender.getPower()) < 11 ){
			
		}
	}
	@Override
	public void attackToNeutralize(Card attacker, GroupCard defender) {
		// TODO Auto-generated method stub
		
	}
	
	/** Display puppets in file-hierarchy form
	 * 
	 */
	public void displayPuppets(){
		
	}
	
}

