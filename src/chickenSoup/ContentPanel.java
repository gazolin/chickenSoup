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
		this.shot = new ShotAnimation();
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
		add(shot.getShot());
		setFocusable(true);  

	}
	public int getSizeOfSky() {
		return img.getWidth(this);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

	public void shot() {
		shot.getShot().setLocation(ship.getLocation().x - 100, ship.getLocation().y- 250);
		shot.getShot().setVisible(true);
		timer = new Timer(100, this);
		timer.start();
	}
	
	private void checkForHits() {
		Set<Chicken> optional = chickens.getLowerChickens();
		boolean hit = false;
		for (Chicken chicken : optional) {
			if (!hit) {
				hit = Util.jComponentlOverlap(shot.getShot(), chicken.getLabel());
				if (hit) {
					currShot.shooting(chicken);
					stopShot();
				}
			}
		}
		
	}
	
	private void stopShot() {
		timer.stop();
		timer = null;
		shot.getShot().setVisible(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		shot.getShot().setLocation(shot.getShot().getLocation().x, shot.getShot().getLocation().y-10);
		checkForHits();
		repaint();
	}
}

