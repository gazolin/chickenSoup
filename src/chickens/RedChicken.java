package chickens;

import javax.swing.ImageIcon;

import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;
import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;

public class RedChicken extends Chicken {

	private String color;

	public RedChicken(Cord cord, ChickenMatrix chickens) {
		super(cord, chickens);
		
		this.color = "purple";
		button.setIcon(new ImageIcon("red.png"));
	}

	@Override
	public void visit(RedShot shot) {
		System.out.println("Red shot red chicken");
		
	}

	@Override
	public void visit(BlackShot shot) {
		System.out.println("black shot red chicken");
		
	}

	@Override
	public void visit(BlueShot blueShot) {
		System.out.println("blue shot red chicken");
		
	}

	@Override
	public void visit(YellowShot yellowShot) {
		System.out.println("yellow shot red chicken");
		
	}
}
