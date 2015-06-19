package ship;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;


public class SpaceShip{
	
	private final int WIDTH = 8;
	
	private JLabel ship;
	private ImageIcon img;  
	private Timer timer;
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
