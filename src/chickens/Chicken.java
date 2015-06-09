package chickens;

import java.awt.Color;
import java.awt.Dimension;

//import javafx.scene.layout.Border;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;


public abstract class Chicken implements Visitor {

	private Cord cord;
	private ChickenMatrix chickens;
	protected JButton button;
	
	public Chicken(Cord cord, ChickenMatrix chickens) {
		this.cord = cord;
		this.chickens = chickens;
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
	
	public void setIconByColor(int color) {
		
		switch(color) {
		case 1:
			button.setIcon(new ImageIcon("red.png"));
			break;
		case 2:
			button.setIcon(new ImageIcon("blue.png"));
			break;
		case 3:
			button.setIcon(new ImageIcon("yellow.png"));
			break;
		case 4:
			button.setIcon(new ImageIcon("orange.png"));
			break;
		}
			
	}


}
