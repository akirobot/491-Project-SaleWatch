import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;


public abstract class Card{

	protected float x, y;
	protected int width, height;
	protected String cardName;
	protected CardType cardType;
	protected BufferedImage face;
	protected BufferedImage back;
	protected boolean faceUP;
	protected Rectangle bounds;
	
	public Card(float x, float y, int width, int height, String name, CardType type, 
			BufferedImage face, BufferedImage back, boolean faceUP){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.cardName = name;
		this.cardType = type;
		this.face = face;
		this.back = back;
		this.faceUP = faceUP;
		bounds = new Rectangle((int)x, (int)y, width, height);
	}
	
	
	public abstract void onClick();
	
	public void onMouseMove(MouseEvent e){
		
	}
	
	public void onMouseRelease(MouseEvent e){
		
	}
	
	public float getX() {
		return x;
	}


	public void setX(float x) {
		this.x = x;
	}


	public float getY() {
		return y;
	}


	public void setY(float y) {
		this.y = y;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public String getCardName() {
		return cardName;
	}


	public void setCardName(String cardName) {
		this.cardName = cardName;
	}


	public CardType getCardType() {
		return cardType;
	}


	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}


	public BufferedImage getFace() {
		return face;
	}


	public void setFace(BufferedImage face) {
		this.face = face;
	}


	public BufferedImage getBack() {
		return back;
	}


	public void setBack(BufferedImage back) {
		this.back = back;
	}


	public boolean isFaceUP() {
		return faceUP;
	}


	public void setFaceUP(boolean faceUP) {
		this.faceUP = faceUP;
	}


	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
