package shots;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ShotAnimation {
	private JLabel shot;
	private ImageIcon img;

	public ShotAnimation(int type) {
		shot = new JLabel();
		
		switch (type) {
			case 1:
				img = new ImageIcon("pictures//blackShot.png");
				break;
			case 2:
				img = new ImageIcon("pictures//redShot.png");
				break;

			case 3:
				img = new ImageIcon("pictures//blueShot.png");
				break;

			case 4:
				img = new ImageIcon("pictures//yellowShot.png");
				break;
		}
		
		shot.setIcon(img);
		shot.setVisible(false);
	} 

	public JLabel getShot() {
		return shot;
	}

}
