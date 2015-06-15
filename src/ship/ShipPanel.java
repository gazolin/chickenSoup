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
	
	public SpaceShip getShip() {
		return ship;
	}



}
