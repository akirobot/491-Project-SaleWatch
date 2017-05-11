import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;



public class Game implements Runnable {

	private final static int WIDTH = 1280;
	private final static int HEIGHT = 720;
	private GameFrame gameFrame;
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//Action Listener
	private MouseManager mouseManager;
	
	//Game states
	public State menuState;
	public State gameState;
	
	//Handler
	private Handler handler;
	
	public Game(){
		mouseManager = new MouseManager();
	}
	
	public synchronized void start(){
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running){
			return;
		}
		running = false;
		try{
			thread.join();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void run() {
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		//int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				//ticks++;
				delta--;
			}
			if(timer >= 1000000000){
				//System.out.println("Ticks and Frames: " + ticks);
				//ticks = 0;
				timer = 0;
			}
			
		}
		stop();
	}

	private void init() {
		gameFrame = new GameFrame(WIDTH, HEIGHT, "Illuminati Card");
		Assets.init();
		Decks.init();
		gameFrame.addMouseListener(mouseManager);
		gameFrame.addMouseMotionListener(mouseManager);
		((Component) gameFrame.getCanvas()).addMouseListener(mouseManager);
		((Component) gameFrame.getCanvas()).addMouseMotionListener(mouseManager);
		handler = new Handler(this);
		menuState = new MenuState(handler);
		gameState = new GameState(handler);
		State.setState(menuState);
		
	}

	private void render() {
		bs = gameFrame.getDisplayArea().getBufferStrategy();
		if(bs == null){
			gameFrame.getDisplayArea().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);
		//Draw
		
		if(State.getState() != null){
			State.getState().render(g);
		}
		
		//End Draw
		g.dispose();
		bs.show();
	}

	private void tick() {
		if(State.getState() != null){
			State.getState().tick();
		}
	}
	
	public static void main(String[] args) {
		 Game game = new Game();
		 game.start();
	}

	public int getWidth() {
		return gameFrame.getWidth();
	}

	public int getHeight() {
		return gameFrame.getHeight();
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

}
