import java.util.ArrayList;

public class GroupCard extends Card implements Attack, cardStats,
	cardUpdateStats {

    private int resistance;
    private Card master;
    private Illuminati illuminati;
    private ArrayList<GroupCard> puppets = new ArrayList<GroupCard>();
    private ArrayList<String> alignments = new ArrayList<String>();

    private int income;
    private int treasury;
    private int power;
    private int transferrablePower;

    private Arrow top;
    private Arrow bottom;
    private Arrow left;
    private Arrow right;

    public GroupCard(String name, int type, int power, int tPower,
	    int resistance, int income) {
	super(name, type, power, tPower, resistance, income);
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
    public int adjustTreasury(int megaBucks) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public int adjustPower(int power) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public int adjustTransferrablePower(int tPower) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public int getIncome() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public int getTreasury() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public int getPower() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public int getTransferrablePower() {
	// TODO Auto-generated method stub
	return 0;
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
