package chickenSoup;

import java.awt.Color;
import java.awt.Dimension;

import javafx.scene.layout.Border;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Chicken {

	private Cord cord;
	private ChickenMatrix chickens;
	private Color color;
	private JButton button;
	
	
	public Chicken(Cord cord, ChickenMatrix chickens) {
		this.cord=cord;
		this.chickens=chickens;
		button = new JButton();
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
				
	}
	
	
	public JButton getButton(){
		return button;
	}
	
	public Cord getCord(){
		return cord;
	}
	
	public void setIconByColor(int color) {
		
		switch(color){
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
