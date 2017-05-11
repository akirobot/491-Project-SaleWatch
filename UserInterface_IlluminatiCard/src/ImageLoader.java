import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImageLoader{
	
	
	public static BufferedImage loadImages(String name){
		try {
			return ImageIO.read(ImageLoader.class.getResource("/images/"+name+".png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
}
