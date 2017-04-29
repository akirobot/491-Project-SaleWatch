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
		
	this.incomeDefault = income;
	this.powerDefault = power;
	    this.transferrablePowerDefault = tPower;
	    this.resistanceDefault = resistance;
	    
	    this.income = income;
	    this.power = power;
	    this.transferrablePower = tPower;
	    this.resistance = resistance;
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
    
    
    // Every Group Card has one incoming Arrow, either on its left or right.
    public Arrow getIncomingArrow(){
	if(this.left instanceof IncomingArrow){
	    System.out.println("305a This Group Card has a Left Incoming Arrow");
	    return this.left;
	} else {
	    System.out.println("305b This Group Card has a Right Incoming Arrow");
	    return this.right;
	}
    }

    public Arrow getTopArrow() {
	return top;
    }

    public Arrow getBottomArrow() {
	return bottom;
    }

    public Arrow  getLeftArrow() {
	return left;
    }

    public Arrow  getRightArrow() {
	return right;
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

    /**
     * Add a puppet to this Group Card
     * Set the puppet's master to this Group Card
     * @param puppet
     */
    public void addPuppet(GroupCard puppet) {
	puppets.add(puppet);
	// Next steps
	// 1) Check if available arrows
	// 2) Which arrow to add puppet to? Top, Bot, Left, Right
	puppet.setMaster(this);
    }
    
/**
 * 
 * @param puppet
 * @param arrowDirection - 1:TOP, 2:BOTTOM, 3: LEFT, 4:RIGHT
 */
    public void addPuppetWithArrow (GroupCard puppet, int arrowDirection) {
	puppets.add(puppet);
	// Check if available "outgoing" arrows
	// Check if puppet has an available incoming arrow spot
	// With the Game UI graphics, we need to check if the arrow isn't blocked by another card, such as collision detection.
	int Top = 1;
	int Bottom = 2;
	int Left = 3;
	int Right = 4;
	
	
	
	// A Group Card's incoming arrow is either the left or right direction, but never the top or bottom direction
	// So we check the left and right of the puppet's incoming arrow
	if((puppet.getLeftArrow() instanceof IncomingArrow) && (puppet.getLeftArrow().getCardFromArrow() == null)){
	    addPuppetWithArrowTwo(puppet, arrowDirection);
	 // Set this Group Card as the master of the puppet
		puppet.setMaster(this); // Have to have incoming arrow direction in mind as well. 
		puppet.getLeftArrow().addCardToArrow(this);
	} else if( (puppet.getRightArrow() instanceof IncomingArrow && puppet.getRightArrow().getCardFromArrow() == null)){
	    addPuppetWithArrowTwo(puppet, arrowDirection);
	 // Set this Group Card as the master of the puppet
		puppet.setMaster(this); // Have to have incoming arrow direction in mind as well. 
		puppet.getRightArrow().addCardToArrow(this);

	}
	
	/*
	if(arrowDirection == Top){
	    // TOP
	    if((this.getTopArrow() instanceof OutgoingArrow) && (this.getTopArrow().getPuppetFromArrow() == null) ){
		    System.out.println("303a Top Outgoing arrow is added with this puppet: " + puppet.getCardName());
		    this.getTopArrow().addPuppetToArrow(puppet);
		} else if((this.getTopArrow() instanceof OutgoingArrow) && (this.getTopArrow().getPuppetFromArrow() != null)){
		    System.out.println("303b Top Outgoing arrow is already occupied");
		} else {
		    System.out.println("303c You can't add a puppet to an Incoming arrow. Or the top arrow does not exists");
		}
	} else if(arrowDirection == Bottom){
	    // BOTTOM
	    if((this.getBottomArrow() instanceof OutgoingArrow) && (this.getBottomArrow().getPuppetFromArrow() == null) ){
		    System.out.println("304a Bottom Outgoing arrow is added with this puppet: " + puppet.getCardName());
		    this.getBottomArrow().addPuppetToArrow(puppet);
		} else if((this.getBottomArrow() instanceof OutgoingArrow) && (this.getBottomArrow().getPuppetFromArrow() != null)){
		    System.out.println("304b Bottom Outgoing arrow is already occupied");
		} else {
		    System.out.println("304c You can't add a puppet to an Incoming arrow. Or the bottom arrow does not exists");
		}
	} else if(arrowDirection == Left){
	    // LEFT
	    if((this.getLeftArrow() instanceof OutgoingArrow) && (this.getLeftArrow().getPuppetFromArrow() == null) ){
		    System.out.println("305a Left Outgoing arrow is added with this puppet: " + puppet.getCardName());
		    this.getLeftArrow().addPuppetToArrow(puppet);
		} else if((this.getLeftArrow() instanceof OutgoingArrow) && (this.getLeftArrow().getPuppetFromArrow() != null)){
		    System.out.println("305b Left Outgoing arrow is already occupied");
		} else {
		    System.out.println("305c You can't add a puppet to an Incoming arrow. Or the left arrow does not exists");
		}
	} else if(arrowDirection == Right){
	    // RIGHT
	    if((this.getRightArrow() instanceof OutgoingArrow) && (this.getRightArrow().getPuppetFromArrow() == null) ){
		    System.out.println("306a Right Outgoing arrow is added with this puppet: " + puppet.getCardName());
		    this.getRightArrow().addPuppetToArrow(puppet);
		} else if((this.getRightArrow() instanceof OutgoingArrow) && (this.getRightArrow().getPuppetFromArrow() != null)){
		    System.out.println("306b Right Outgoing arrow is already occupied");
		} else {
		    System.out.println("306c You can't add a puppet to an Incoming arrow. Or the right arrow does not exists");
		}
	} else {
	    System.out.println("310 Invalid arrowDirection choice");
	}
	*/
	
	
    }
    
    public void addPuppetWithArrowTwo(GroupCard puppet, int arrowDirection){
	int Top = 1;
	int Bottom = 2;
	int Left = 3;
	int Right = 4;
	
	if(arrowDirection == Top){
	    // TOP
	    if((this.getTopArrow() instanceof OutgoingArrow) && (this.getTopArrow().getCardFromArrow() == null) ){
		    System.out.println("303a Top Outgoing arrow is added with this puppet: " + puppet.getCardName());
		    this.getTopArrow().addCardToArrow(puppet);
		} else if((this.getTopArrow() instanceof OutgoingArrow) && (this.getTopArrow().getCardFromArrow() != null)){
		    System.out.println("303b Top Outgoing arrow is already occupied");
		} else {
		    System.out.println("303c You can't add a puppet to an Incoming arrow. Or the top arrow does not exists");
		}
	} else if(arrowDirection == Bottom){
	    // BOTTOM
	    if((this.getBottomArrow() instanceof OutgoingArrow) && (this.getBottomArrow().getCardFromArrow() == null) ){
		    System.out.println("304a Bottom Outgoing arrow is added with this puppet: " + puppet.getCardName());
		    this.getBottomArrow().addCardToArrow(puppet);
		} else if((this.getBottomArrow() instanceof OutgoingArrow) && (this.getBottomArrow().getCardFromArrow() != null)){
		    System.out.println("304b Bottom Outgoing arrow is already occupied");
		} else {
		    System.out.println("304c You can't add a puppet to an Incoming arrow. Or the bottom arrow does not exists");
		}
	} else if(arrowDirection == Left){
	    // LEFT
	    if((this.getLeftArrow() instanceof OutgoingArrow) && (this.getLeftArrow().getCardFromArrow() == null) ){
		    System.out.println("305a Left Outgoing arrow is added with this puppet: " + puppet.getCardName());
		    this.getLeftArrow().addCardToArrow(puppet);
		} else if((this.getLeftArrow() instanceof OutgoingArrow) && (this.getLeftArrow().getCardFromArrow() != null)){
		    System.out.println("305b Left Outgoing arrow is already occupied");
		} else {
		    System.out.println("305c You can't add a puppet to an Incoming arrow. Or the left arrow does not exists");
		}
	} else if(arrowDirection == Right){
	    // RIGHT
	    if((this.getRightArrow() instanceof OutgoingArrow) && (this.getRightArrow().getCardFromArrow() == null) ){
		    System.out.println("306a Right Outgoing arrow is added with this puppet: " + puppet.getCardName());
		    this.getRightArrow().addCardToArrow(puppet);
		} else if((this.getRightArrow() instanceof OutgoingArrow) && (this.getRightArrow().getCardFromArrow() != null)){
		    System.out.println("306b Right Outgoing arrow is already occupied");
		} else {
		    System.out.println("306c You can't add a puppet to an Incoming arrow. Or the right arrow does not exists");
		}
	} else {
	    System.out.println("310 Invalid arrowDirection choice");
	}
    }
    

    public void addAlignment(String alignment) {
	alignments.add(alignment);
    }

    /**
     * When a Group Card gets destroyed or neutralized, set its master to null
     */
    public void resetMaster(){
	this.master = null;
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
    	System.out.println("\t Transferrable Power: " + this.getTransferPower());
    	System.out.println("\t Resistance: " + this.getResistance());
    	System.out.println("\t MegaBucks: " + this.getTreasury()); // megaBucks
    	System.out.println("\t Income: " + this.getIncome());
    	
    	for(int i = 0 ; i < alignments.size(); i++){
        	System.out.println("\t Aliignment: " + this.alignments.get(i));
    	}


    	
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
