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
import javax.swing.Timer;

import ship.*;
import shots.ShotAnimation;

public class ContentPanel extends JPanel {

	private Image img;
	private ChickenMatrix chickens;
	private SpaceShip ship;
	private ShipPanel shipPanel;
	private ShotAnimation shot;
	private Timer timer;
	private int x, y;

	public ContentPanel(Image img, ChickenMatrix chickens, ShipPanel shipPanel) {
		this.img = img;
		this.shot = new ShotAnimation();
		this.shipPanel = shipPanel;
		this.ship = shipPanel.getShip();
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
		add(shot.getLabel());
		setFocusable(true);  

	}
	public int getSizeOfSky() {
		return img.getWidth(this);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

	public void shot() {
		shot.getLabel().setLocation(ship.getLocation().x - 100, ship.getLocation().y- 250);
		shot.getLabel().setVisible(true);
		timer = new Timer(200, shot);
		timer.start();
	}
}

