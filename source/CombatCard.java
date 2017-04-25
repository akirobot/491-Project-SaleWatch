
public class CombatCard extends Card implements cardStats, cardUpdateStats  {

    private int income;
    private int treasury;
    private int power;
    private int transferrablePower;
    private int outgoingArrows;
    
    private Arrow top;
    private Arrow bottom;
    private Arrow left;
    private Arrow right;
     
    public CombatCard(String name, int income, int power, int tPower, int outgoingArrows){
	super(name);
	
    }
    
    public void addIncomeAtStartOfTurn(){
	// this.treasury += this.income;
    }

    public void moveMegaBucks(){
	
    }
    
    public void movePuppets(){
	
    }
    
  //  @Override
  //  public int getName() {
//	// TODO Auto-generated method stub
//	return 0;
  //  }
//
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
}
