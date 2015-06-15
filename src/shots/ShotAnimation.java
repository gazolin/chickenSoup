package shots;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import chickenSoup.ContentPanel;

public class ShotAnimation extends JLabel implements ActionListener {
	private double x, y;
	private JLabel label;
	private ImageIcon img;
	//private ContentPanel sky;

	public ShotAnimation() {
		img = new ImageIcon("pictures//shot.png");
		label = new JLabel();
		label.setIcon(img);
		label.setVisible(false);
	} 

	public JLabel getLabel(){
		return label;
	}

	public void actionPerformed(ActionEvent e) {
		x = label.getLocation().getX();
		y = label.getLocation().getY() - 20;
		label.setLocation(label.getLocation().x, label.getLocation().y-10);
		repaint();
	}


}
