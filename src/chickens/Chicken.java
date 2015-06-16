package chickens;

import java.awt.Color;
import java.awt.Dimension;

//import javafx.scene.layout.Border;





import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;


public abstract class Chicken implements Visitor {

	protected Cord cord;
	protected ChickenMatrix matrix;
	protected JLabel label;
	protected String kind;
	protected boolean alive;
	
	public Chicken(Cord cord, ChickenMatrix matrix) {
		this.cord = cord;
		this.matrix = matrix;
		alive = true;
		label = new JLabel();
		//label.setOpaque(false);
		//label.setContentAreaFilled(false);
		//label.setBorderPainted(false);	

	}
	
	public JLabel getLabel() {
		return this.label;
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
//		this.button.setIcon(new ImageIcon("explosion.png"));
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {}
		this.label.setVisible(false);
		matrix.remove(this.label);	//added this so later we can shoot where no chicken exists (maybe just need a flag)
		this.matrix.reduceCount();
		this.alive = false;
	}

}
