import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class CardManager {
	
	private Handler handler;
	private ArrayList<Card> cardToDraw;
	
	public CardManager(Handler handler){
		this.setHandler(handler);
		cardToDraw = new ArrayList<Card>();
	}
	
	public void tick(){
		for(Card o : cardToDraw){
			o.tick();
		}
	}
	
	public void render(Graphics g){
		for(Card o : cardToDraw){
			o.render(g);
		}
	}
	
	public void onMouseMove(MouseEvent e){
		for(Card o : cardToDraw){
			o.onMouseMove(e);
		}
	}
	
	public void onMouseRelease(MouseEvent e){
		for(Card o : cardToDraw){
			o.onMouseRelease(e);
		}
	}
	
	public void addCard(Card o){
		cardToDraw.add(o);
	}
	
	public void removeCard(Card o){
		cardToDraw.remove(o);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
