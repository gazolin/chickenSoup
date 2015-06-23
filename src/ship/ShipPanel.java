package ship;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ShipPanel extends JPanel {
	
	private SpaceShip ship;
	
	public ShipPanel(SpaceShip ship, int widthOfSky){
		this.ship = ship;
		this.setLayout(null);
		
		add(ship.getLabel());
		ship.getLabel().setLocation(widthOfSky/2-50,0);
		ship.getLabel().setSize(ship.getLabel().getIcon().getIconWidth(), ship.getLabel().getIcon().getIconHeight());
		setOpaque(false);
    	setFocusable(true);
		setVisible(true);
	}
	
	public SpaceShip getShip() {
		return ship;
	}



}
