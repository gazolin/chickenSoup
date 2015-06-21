package chickenSoup;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import ship.ShipPanel;
import shots.ShotAnimation;
import chickens.Chicken;

@SuppressWarnings("serial")
public class ContentPanel extends JPanel implements ActionListener {

	private Image img;
	private ChickenMatrix chickens;
	private ShipPanel shipPanel;
	private JLabel shot;
	private JLabel ship;
	private Timer timer;
	private int x, y;
	private int distance;
	private int shipLocation;
	private Level level;
	private ToolBar toolBar;

	public ContentPanel(Image img, ChickenMatrix chickens, ShipPanel shipPanel, Level level, ToolBar toolBar) {
		
		
		this.img = img;
		this.shipPanel = shipPanel;
		this.ship = shipPanel.getShip().getLabel();
		this.distance = 0;
		this.chickens = chickens;
		this.level = level;
		this.toolBar = toolBar;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(chickens);
		add(Box.createVerticalStrut(250));
		add(shipPanel);
		
		setFocusable(true); 
		

	}
	public int getWidthOfSky() {
		return img.getWidth(this);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

	public void shot(int x, int type, boolean normal) {
		shipLocation = x;
		this.setLayout(null);
	    shot =(new ShotAnimation(type)).getShot();
	    if (normal)
	    	add(shot);
	    shot.setLocation (shipLocation+20, ship.getY() + distance);
	    shot.setSize(shot.getIcon().getIconWidth(), shot.getIcon().getIconHeight());
	    shot.setVisible(true);
	  
		
		timer = new Timer(12, this);
		timer.start();
		
		toolBar.increaseShots(normal);
	}
	
	private void checkForHits() {
		Set<Chicken> optional = chickens.getLowerChickens();
		boolean hit = false;
		Chicken deadChicken = null;
		for (Chicken chicken : optional) {

			if((chicken.getLabel().getX() > shot.getX() -80 && chicken.getLabel().getX() < shot.getX() + 20)
					&& (chicken.getLabel().getY() > shot.getY() - 20 )){
				chicken.getLabel().getLocation(shot.getLocation());
				hit = true;
				deadChicken = chicken;
			}
				
			if (hit) {
				level.getShot().shooting(deadChicken);
				stopShot();
				break;
			}	
		}
	}
	
	private void stopShot() {
		timer.stop();
		shot.setVisible(false);
		distance = 400;
    	ship.setLocation(shipLocation,0);
    	level.resetIsShot();
	}
	
	private void isBorder(){
		if(shot.getLocation().getY() <- 50)
			stopShot();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		shot.setLocation (shipLocation + 25, ship.getY() + distance + 130);
    	ship.setLocation(shipLocation,0);

		distance-=10;
		checkForHits();
		isBorder();
	}
}

