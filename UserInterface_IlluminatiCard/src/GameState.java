import java.awt.Graphics;


public class GameState extends State {
	
	private CardManager cardManager;
	
	public GameState(Handler handler){
		super(handler);
		cardManager = new CardManager(handler);
		
		//Game process here
		
		/////Need rules for game run
		/////And add card to CardManager so it automatically draw cards.
		
		
		
		
		
		
		
		
		
	}
	
	@Override
	public void tick() {
		//This Function Keep Updating the components to draw
		cardManager.tick();
	}

	@Override
	public void render(Graphics g) {
		//This Function Keep Update Drawing
		cardManager.render(g);
	}

}
