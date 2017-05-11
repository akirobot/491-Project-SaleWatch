import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class ImageButton extends UIObject{

	private BufferedImage[] images;
	private ClickListener clicker;
	private String str;
	
	public ImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker, String str) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
		this.str = str;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		if(hovering){
			g.drawImage(images[1], (int) x,(int) y, width, height, null);
			g.drawString(str, (int)x,(int) y);
		} else {
			g.drawImage(images[0], (int) x,(int) y, width, height, null);
		}
		
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

}
