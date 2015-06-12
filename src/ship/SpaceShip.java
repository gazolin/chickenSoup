package ship;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class SpaceShip extends JLabel implements KeyListener {
	
	private final int WIDTH = 8;
	
	private JLabel ship;
	private ImageIcon img;  
	

	
	
	public SpaceShip(){
		ship = new JLabel();
		img = new ImageIcon("spaceShip.png");
		ship.setIcon(img);
		setFocusable(true);
		
		//matrix = new JPanel[WIDTH];
		//initMatrix();
		//panel.add(ship);
		//matrix[3].add(ship);
		
	}
	
	public JLabel getLabel(){
		return ship;
	}
	
	
	/*public void initMatrix() {
		for (int i = 0; i < WIDTH; i++) {
			matrix[i] = new JPanel();
			matrix[i].addKeyListener(this);
			panel.add(matrix[i]);
		}
	}
	*/
	@Override
	public void keyPressed(KeyEvent e) {
	    int key = e.getKeyCode();
	    System.out.println("!!!!!!");

	    if (key == KeyEvent.VK_LEFT) {
	        System.out.println("left");
	    }

	    if (key == KeyEvent.VK_RIGHT) {
	        System.out.println("right");
	    }

		
	}

	@Override
	public void keyReleased(KeyEvent key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent key) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
