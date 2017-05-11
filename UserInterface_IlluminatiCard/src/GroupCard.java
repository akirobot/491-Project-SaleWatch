import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class GroupCard extends Card {
	
	private int power;
	private int tpower;
	private int resistance;
	private int income;
	private ArrowGoing[] arrow;
	private boolean specialAbility;
	
	public final int WIDTH = 80, HEIGHT = 50;
	
	public GroupCard(float x, float y, int width, int height, String name,
			CardType type, BufferedImage face, BufferedImage back,
			boolean faceUP, int power, int tpower, int resistance, 
			int income, ArrowGoing[] arrow, boolean specialAbility) {
		super(x, y, width, height, name, type, face, back, faceUP);
		this.power = power;
		this.tpower = tpower;
		this.resistance = resistance;
		this.income = income;
		this.arrow = arrow;
		this.specialAbility = specialAbility;
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getTpower() {
		return tpower;
	}

	public void setTpower(int tpower) {
		this.tpower = tpower;
	}

	public int getResistance() {
		return resistance;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public ArrowGoing[] getArrow() {
		return arrow;
	}

	public void setArrow(ArrowGoing[] arrow) {
		this.arrow = arrow;
	}

	public boolean isSpecialAbility() {
		return specialAbility;
	}

	public void setSpecialAbility(boolean specialAbility) {
		this.specialAbility = specialAbility;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}



}
