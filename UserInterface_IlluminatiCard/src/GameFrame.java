import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GameFrame extends JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 7154330929505524348L;
	
	private int xMouse;
    private int yMouse;
    private boolean maximized = true;
    
    private final Color DARK_BLUE = new Color(42,91,132);
    private final Color LIGHT_BG = new Color(254,250,225);
	
	private JPanel leftSideBar, RightContainer, UerActionArea;
	private Canvas DisplayArea;
	private JLabel logo, Close_BTN, Minimize_BTN, Maximize_BTN;
	
	/**
	 * 
	 * @param evt
	 */
	private void leftSideBarMouseDragged(MouseEvent evt) {
		int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
	}
	
	/**
	 * 
	 * @param evt
	 */
	private void Close_BTNMouseReleased(MouseEvent evt) {
		System.exit(0);
	}
	
	/**
	 * 
	 * @param evt
	 */
	private void leftSideBarMousePressed(MouseEvent evt) {
		xMouse = evt.getX();
        yMouse = evt.getY();
	}
	
	/**
	 * 
	 * @param evt
	 */
	private void Minimize_BTNMouseReleased(MouseEvent evt) {
		this.setState(GameFrame.ICONIFIED);
	}
	
	/**
	 * 
	 * @param evt
	 */
	private void Maximize_BTNMouseReleased(MouseEvent evt) {
		if(maximized){
			GameFrame.this.setExtendedState(JFrame.MAXIMIZED_BOTH);  
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();  
            GameFrame.this.setMaximizedBounds(env.getMaximumWindowBounds());
            maximized = false;
        } else {
            setExtendedState(JFrame.NORMAL);
            maximized = true;
        }
	}
	
	public Canvas getDisplayArea(){
		return DisplayArea;
	}
	
	/**
	 * 
	 * @param width
	 * @param height
	 * @param title
	 * @param game
	 */
	public GameFrame(int width, int height, String title){
		
		//Layout gameUI
		//left side panel
		leftSideBar = new JPanel();
		logo = new JLabel();
		Close_BTN = new JLabel();
        Minimize_BTN = new JLabel();
        Maximize_BTN = new JLabel();
        //Right side container
        RightContainer = new JPanel();
        DisplayArea = new Canvas();
        UerActionArea = new javax.swing.JPanel();
		
        
        //Initialize components
        leftSideBar.setBackground(DARK_BLUE);
        leftSideBar.setPreferredSize(new Dimension(50, this.getPreferredSize().height));
        leftSideBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                leftSideBarMouseDragged(evt);
            }
        });
        leftSideBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                leftSideBarMousePressed(evt);
            }
        });
        
        Close_BTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Close_BTN.png")));
        Close_BTN.setToolTipText("Exit");
        Close_BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Close_BTNMouseReleased(evt);
            }
        });

        Minimize_BTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Minimize_BTN.png")));
        Minimize_BTN.setToolTipText("Minimize");
        Minimize_BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Minimize_BTNMouseReleased(evt);
            }
        });

        Maximize_BTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Maximize_BTN.png")));
        Maximize_BTN.setToolTipText("Maximize");
        Maximize_BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Maximize_BTNMouseReleased(evt);
            }
        });
        
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png")));
        logo.setToolTipText("Illuminati Card Game");
        
        
        UerActionArea.setBackground(new Color(237,229,214));
        UerActionArea.setPreferredSize(new Dimension(this.getPreferredSize().width, 50));
        
        DisplayArea.setBackground(LIGHT_BG);
        
        //Set components layouts
        setLayout(new BorderLayout());
        leftSideBar.setLayout(new FlowLayout(FlowLayout.CENTER));
        RightContainer.setLayout(new BorderLayout());
        
        //add components
        this.add(leftSideBar, BorderLayout.WEST);
        leftSideBar.add(Close_BTN);
        leftSideBar.add(Minimize_BTN);
        leftSideBar.add(Maximize_BTN);
        this.add(RightContainer, BorderLayout.CENTER);
        RightContainer.add(DisplayArea, BorderLayout.CENTER);
        RightContainer.add(UerActionArea, BorderLayout.SOUTH);
        
        
        
		//Top frame bar
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(title);
		//Set size of the frame
		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));
		//Center the frame
		this.setLocationRelativeTo(null);
		//Unresizbale and visible
		this.setResizable(false);
		this.setUndecorated(true);
		this.pack();
		this.setVisible(true);
	}

	public Object getCanvas() {
		return DisplayArea;
	}
	
	
}
