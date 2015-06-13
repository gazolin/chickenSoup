package ship;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import shots.Shot;


public class SpaceShip extends JLabel implements ActionListener {
	
	private final int WIDTH = 8;
	
	private JLabel ship;
	private ImageIcon img;  
	private Timer timer;
	private JLabel currShot;	//TODO - maybe a field of shot
	private ShipPanel panel;

	public SpaceShip(){
		ship = new JLabel();
		img = new ImageIcon("pictures//spaceShip.png");
		ship.setIcon(img);
		currShot = null;
		setFocusable(true);
		
	}
	
	public JLabel getLabel() {
		return ship;
	}
	
	public void setPanel(ShipPanel panel) {
		this.panel = panel;
	}
	
	public JLabel getCurrShot() {
		return currShot;
	}
	
	public void shot() {
		currShot = new JLabel();
		currShot.setIcon(new ImageIcon("shot.png"));
		currShot.setVisible(true);
		panel.add(currShot);
		panel.neetToRepaint();		
		
		if (timer == null) {
			System.out.println("2222");
			timer = new Timer(20, this);
			timer.setInitialDelay(50);
			timer.start();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		currShot.setLocation(currShot.getLocation().x,currShot.getLocation().y-10);
		
	}

}
