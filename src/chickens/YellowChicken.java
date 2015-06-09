package chickens;

import javax.swing.ImageIcon;

import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;
import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;

public class YellowChicken extends Chicken {

	public YellowChicken(Cord cord, ChickenMatrix chickens) {
		super(cord, chickens);
		
		this.kind = "purple";
		button.setIcon(new ImageIcon("yellow.png"));
	}

	@Override
	public void visit(RedShot shot) {
		System.out.println("Red shot yellow chicken");
		
	}

	@Override
	public void visit(BlackShot shot) {
		System.out.println("black shot yellow chicken");
		
	}

	@Override
	public void visit(BlueShot blueShot) {
		System.out.println("blue shot yellow chicken");
		
	}

	@Override
	public void visit(YellowShot yellowShot) {
		System.out.println("yellow shot yellow chicken");
		this.die();
	}
}
