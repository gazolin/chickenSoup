package shots;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ShotAnimation {
	private JLabel shot;
	private ImageIcon img;

	public ShotAnimation() {
		img = new ImageIcon("pictures//shot.png");
		shot = new JLabel();
		shot.setIcon(img);
		shot.setVisible(false);
	} 

	public JLabel getShot() {
		return shot;
	}

}
