package ship;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SpaceShip extends JLabel implements KeyListener {
	
	private JLabel ship;
	private ImageIcon img;  
	public SpaceShip(){
		ship = new JLabel();
		img = new ImageIcon("spaceShip.png");
		ship.setIcon(img);
		
	}
	
	public JLabel getLabel(){
		return ship;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
