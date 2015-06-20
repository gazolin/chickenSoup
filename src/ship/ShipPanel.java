package ship;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShipPanel extends JPanel {
	
	private SpaceShip ship;
	
	public ShipPanel(SpaceShip ship){
		this.ship = ship;
		
		this.setLayout(null);
		
		add(ship.getLabel());
		ship.getLabel().setLocation(400,0);
		ship.getLabel().setSize(ship.getLabel().getIcon().getIconWidth(), ship.getLabel().getIcon().getIconHeight());
		setOpaque(false);
    	setFocusable(true);
		setVisible(true);
	

	}
	
	public SpaceShip getShip() {
		return ship;
	}



}
