package ship;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class SpaceShip extends JLabel {
	
	private final int WIDTH = 8;
	
	private JLabel ship;
	private ImageIcon img;  
	

	public SpaceShip(){
		ship = new JLabel();
		img = new ImageIcon("pictures//spaceShip.png");
		ship.setIcon(img);
		setFocusable(true);
		
	}
	
	public JLabel getLabel(){
		return ship;
	}

}
