package chickenSoup;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class RulesPanel extends JPanel {
	
	private Image img;
	
	public RulesPanel(Image img){
		this.img = img;
		
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setVisible(true);
		
	}
	
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}


