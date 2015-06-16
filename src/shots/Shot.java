package shots;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import chickens.Visitor;

public abstract class Shot {
	
	private JLabel shot;
	private ImageIcon img;
	
	public Shot() {
		img = new ImageIcon("pictures//shot.png");
		shot = new JLabel();
		shot.setIcon(img);
		shot.setVisible(false);
	} 
	
	public JLabel getShot() {
		return shot;
	}
	
	//can it be Chicken chicken?
	public abstract void shooting(Visitor v);
}
