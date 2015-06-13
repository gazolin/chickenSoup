package ship;

import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShipPanel extends JPanel {
	
	private SpaceShip ship;
	
	public ShipPanel(SpaceShip ship){
		this.ship = ship;
		add(ship.getLabel());
		setOpaque(false);
    	setFocusable(true);

		setVisible(true);

	}
	
	public void neetToRepaint() {
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		JLabel currShot = ship.getCurrShot();
		if (currShot != null) {
			System.out.println("1111");
			currShot.paint(getGraphics());
		}
	}


}
