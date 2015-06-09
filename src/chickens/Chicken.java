package chickens;

import java.awt.Color;
import java.awt.Dimension;

//import javafx.scene.layout.Border;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;


public abstract class Chicken implements Visitor {

	protected Cord cord;
	protected ChickenMatrix chickens;
	protected JButton button;
	protected String kind;
	protected boolean alive;
	
	public Chicken(Cord cord, ChickenMatrix chickens) {
		this.cord = cord;
		this.chickens = chickens;
		alive = true;
		button = new JButton();
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);	

	}
	
	public JButton getButton() {
		return this.button;
	}
	
	public Cord getCord(){
		return cord;
	}
	
	public String getKind() {
		return this.kind;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void die() {
		this.button.setVisible(false);
		this.chickens.reduceCount();
		this.alive = false;
	}

}
