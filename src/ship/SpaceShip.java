package ship;


<<<<<<< HEAD
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

=======
>>>>>>> origin/master
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class SpaceShip{
		
	private JLabel ship;
	private ImageIcon img;  
	private ShipPanel panel;

	public SpaceShip(){
		ship = new JLabel();
		img = new ImageIcon("pictures//spaceShip.png");
<<<<<<< HEAD
		ship.setIcon(img);		
		
=======
		ship.setIcon(img);
>>>>>>> origin/master
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
