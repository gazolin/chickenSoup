package chickenSoup;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class ContentPanel extends JPanel{
	
	  private Image img;
	  private ChickenMatrix chickens;
	  
	

	  public ContentPanel(Image img, ChickenMatrix chickens) {
	    this.img = img;
	    this.chickens = chickens;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    add(chickens);
	  }

	 public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }
}

