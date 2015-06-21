package shots;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ShotAnimation {
	private JLabel shot;
	private ImageIcon img;

	public ShotAnimation(int type) {
		switch (type) {
			case 1:
				img = new ImageIcon("pictures//blackShot.png");
				shot = new JLabel();
				shot.setIcon(img);
				shot.setVisible(false);
				break;
			case 2:
				img = new ImageIcon("pictures//redShot.png");
				shot = new JLabel();
				shot.setIcon(img);
				shot.setVisible(false);
				break;

			case 3:
				img = new ImageIcon("pictures//blueShot.png");
				shot = new JLabel();
				shot.setIcon(img);
				shot.setVisible(false);
				break;

			case 4:
				img = new ImageIcon("pictures//yellowShot.png");
				shot = new JLabel();
				shot.setIcon(img);
				shot.setVisible(false);
				break;

		}
		
	} 

	public JLabel getShot() {
		return shot;
	}

}
