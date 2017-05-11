import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class IlluminatiCard extends Card {


	private int power;
	private int tPower;
	private int income;
	
	public IlluminatiCard(float x, float y, int width, int height, String name,
			CardType type, BufferedImage face, BufferedImage back,
			boolean faceUP, int power, int tpower, int income) {
		super(x, y, width, height, name, type, face, back, faceUP);
		this.power = power;
		this.tPower = tpower;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int gettPower() {
		return tPower;
	}

	public void settPower(int tPower) {
		this.tPower = tPower;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		
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
