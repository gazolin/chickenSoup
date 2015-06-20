package ship;


import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class SpaceShip{
		
	private JLabel ship;
	private ImageIcon img;  
	private ShipPanel panel;

	public SpaceShip(){
		ship = new JLabel();
		img = new ImageIcon("pictures//spaceShip.png");
		ship.setIcon(img);
	}
	
	public JLabel getLabel() {
		return ship;
	}
	
	public void setPanel(ShipPanel panel) {
		this.panel = panel;
	}
	
	public void shot() {
		//TODO
	}


}
