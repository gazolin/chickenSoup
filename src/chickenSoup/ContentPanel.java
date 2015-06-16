package chickenSoup;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ship.*;
import shots.ShotAnimation;

public class ContentPanel extends JPanel {
		
	  private Image img;
	  private ChickenMatrix chickens;
	  private SpaceShip ship;
	  private ShipPanel shipPanel;
	  private ShotAnimation shot;
	  
	  public ContentPanel(Image img, ChickenMatrix chickens, ShipPanel shipPanel) {
	    this.img = img;
	    this.ship = ship;		//TODO ??
	    this.shot = shot;
	    this.shipPanel=shipPanel;
	    this.chickens = chickens;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	    add(chickens);
	    add(Box.createVerticalStrut(250));
	    add(shipPanel);
		add(new ShotAnimation(this));
    	setFocusable(true);  
	 
	  }
	  public int getSizeOfSky(){
		  return img.getWidth(this);
	  }

	 public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }
}

