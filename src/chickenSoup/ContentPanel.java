package chickenSoup;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ship.SpaceShip;
public class ContentPanel extends JPanel{
		
	  private Image img;
	  private ChickenMatrix chickens;
	  private SpaceShip ship;
	  
	  public ContentPanel(Image img, ChickenMatrix chickens, SpaceShip ship) {
	    this.img = img;
	    this.ship = ship;
	    this.chickens = chickens;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    add(BorderLayout.NORTH, chickens);
	    add(BorderLayout.SOUTH, ship.getLabel());
	 
	  }

	 public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }
}

