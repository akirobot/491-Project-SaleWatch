import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class MouseManager implements MouseListener, MouseMotionListener{

	private boolean mouse_1_Pressed;
	private int mouseX, mouseY;
	private UIManager uiManager;
	
	public MouseManager(){
		
	}
	
	public void setUIManager(UIManager uiManager){
		this.uiManager = uiManager;
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		mouseX = arg0.getX();
		mouseY = arg0.getY();
		
		if(uiManager != null){
			uiManager.onMouseMove(arg0);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if(arg0.getButton() == MouseEvent.BUTTON1){
			mouse_1_Pressed = true;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(arg0.getButton() == MouseEvent.BUTTON1){
			mouse_1_Pressed = false;
		}
		
		if(uiManager != null){
			uiManager.onMouseRelease(arg0);
		}
	}
	
	public boolean isMouse_1_Pressed(){
		return mouse_1_Pressed;
	}
	
	public int getMouseX(){
		return mouseX;
	}
	
	public int getMouseY(){
		return mouseY;
	}

}
