package shots;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import chickenSoup.ContentPanel;

public class ShotAnimation {
	private JLabel shot;
	private ImageIcon img;

	public ShotAnimation(int x) {
		img = new ImageIcon("pictures//shot.png");
		shot = new JLabel();
		shot.setLocation(x, 0);
		shot.setIcon(img);
		shot.setVisible(true);
	} 

	public JLabel getShot() {
		return shot;
	}
	public void setShot(int x){
		shot.setLocation(x, 0);
	}


}
