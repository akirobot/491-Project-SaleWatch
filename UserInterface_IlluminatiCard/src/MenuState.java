import java.awt.Graphics;


public class MenuState extends State {

	private UIManager uiManager;
	
	
	public MenuState(final Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new ImageButton(handler.getWidth() / 2 - 100, 500, 100, 100, Assets.start_BTN, new ClickListener(){

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}},"START"));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
		g.drawImage(Assets.leftBanner, handler.getWidth() / 4 - 300, 50, null);
		g.drawImage(Assets.logo, handler.getWidth() / 4 - 80, 50, null);
		g.drawImage(Assets.rightBanner, handler.getWidth() - 250, 50, null);
	}

}
