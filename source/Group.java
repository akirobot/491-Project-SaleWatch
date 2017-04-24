import java.util.ArrayList;


public class Group extends CombatCard implements Attack {

    private int resistance;
    private CombatCard master;
    private Illuminati illuminati;
    private ArrayList<Group> puppets = new ArrayList<Group>();
    private ArrayList<String> alignments = new ArrayList<String>();

    public Group(String name, int income, int power, int tPower, int resistance, int outgoingArrows) {
	super(name, income, power, tPower, outgoingArrows);
	// TODO Auto-generated constructor stub
    }
    
    public CombatCard getMaster(){
	return null;
    }

    public Group getPuppet(int choice){
	return null;
    }
    public void setMaster(CombatCard master){
	
    }
    
    public void setIlluminati(Illuminati illuminati){
	
    }
    
    public void addPuppet(Group puppet){
	
    }
    
    public void addAlignment(String alignment){
	
    }
    
    public void displayPuppets(){
	
    }

    @Override
    public void attackToControl(CombatCard attacker, Group defender) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void attackToDestroy(CombatCard attacker, Group defender) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void attackToNeutralize(CombatCard attacker, Group defender) {
	// TODO Auto-generated method stub
	
    }
}
