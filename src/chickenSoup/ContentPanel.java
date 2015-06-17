package chickenSoup;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;




import chickens.Chicken;
import ship.*;
import shots.RedShot;
import shots.Shot;
import shots.ShotAnimation;
import sun.management.Util;

public class ContentPanel extends JPanel implements ActionListener {

	private Image img;
	private ChickenMatrix chickens;
	private SpaceShip ship;
	private ShipPanel shipPanel;
	private ShotAnimation shot;
	private Timer timer;
	private int x, y;
	private Shot currShot;	//TODO - get from game/level

	public ContentPanel(Image img, ChickenMatrix chickens, ShipPanel shipPanel) {
		this.img = img;
		shot = new ShotAnimation(0);
		this.shipPanel = shipPanel;
		this.ship = shipPanel.getShip();
		this.chickens = chickens;
		this.currShot = new RedShot();		//TODO - temp
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

	public void shot() {
		
		shot.setShot(ship.getLabel().getX());
		shot.getShot().setVisible(true);
		add(shot.getShot());
		timer = new Timer(15, this);
		timer.start();
	}
	
	private void checkForHits() {
		Set<Chicken> optional = chickens.getLowerChickens();
		boolean hit = false;
		for (Chicken chicken : optional) {
			//if (!hit) {
				//hit = Util.jComponentlOverlap(shot.getShot(), chicken.getLabel());
				if (hit) {
					currShot.shooting(chicken);
					stopShot();
				}
			//}
		}
		
	}
	
	private void stopShot() {
		timer.stop();
		timer = null;
		shot.getShot().disable();
		shot.getShot().setVisible(false);
	}
	
	private void isBorder(){
		if(shot.getShot().getLocation().getY()<-50)
			stopShot();
	}
	
	public void actionPerformed(ActionEvent e) {
		checkForHits();
		isBorder();
		shot.getShot().setLocation(shot.getShot().getLocation().x, shot.getShot().getLocation().y-10);
		shot.getShot().repaint();
	}
}

