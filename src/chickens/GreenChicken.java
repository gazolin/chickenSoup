package chickens;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;
import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;

public class GreenChicken extends Chicken {
	
	public GreenChicken(Cord cord, ChickenMatrix chickens) {
		super(cord, chickens);
		this.kind = "green";
		this.button.setIcon(new ImageIcon("green.png"));
	}

	@Override
	public void visit(RedShot shot) {
		System.out.println("Red shot green chicken");
		
	}

	@Override
	public void visit(BlackShot shot) {
		System.out.println("black shot green chicken");
		
	}

	@Override
	public void visit(BlueShot blueShot) {
		System.out.println("blue shot green chicken");
		this.die();
		
	}

	@Override
	public void visit(YellowShot yellowShot) {
		System.out.println("yellow shot green chicken");
		this.die();
		
	}

	@Override
	public JButton getButton() {
		return this.button;
	}
}
