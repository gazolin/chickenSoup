package chickens;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;
import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;

public class PurpleChicken extends Chicken {

	public PurpleChicken(Cord cord, ChickenMatrix chickens) {
		super(cord, chickens);
		this.kind = "purple";

		button.setIcon(new ImageIcon("red.png"));
	}

	@Override
	public void visit(RedShot shot) {
		System.out.println("Red shot purple chicken");
		
	}

	@Override
	public void visit(BlackShot shot) {
		System.out.println("black shot purple chicken");
		
	}

	@Override
	public void visit(BlueShot blueShot) {
		System.out.println("blue shot purple chicken");
		
	}

	@Override
	public void visit(YellowShot yellowShot) {
		System.out.println("yellow shot purple chicken");
		
	}

}
