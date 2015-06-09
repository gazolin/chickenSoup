package chickens;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;
import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;

public class BlueChicken extends Chicken {

	public BlueChicken(Cord cord, ChickenMatrix matrix) {
		super(cord, matrix);
		this.kind = "blue";
		button.setIcon(new ImageIcon("blue.png"));
	}
	@Override
	public void visit(RedShot shot) {
		System.out.println("Red shot blue chicken");
		for (int i = 0; i < 2; i++) {
			Chicken chicken = this.matrix.getChickenByKind("purple");
			if (chicken != null) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				chicken.die();
			}
		}
		
	}

	@Override
	public void visit(BlueShot shot) {
		System.out.println("blue shot blue chicken");
		this.die();
	}

	@Override
	public void visit(YellowShot shot) {
		System.out.println("yellow shot blue chicken");
		for (int i = 0; i < 2; i++) {
			Chicken chicken = this.matrix.getChickenByKind("green");
			if (chicken != null) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				chicken.die();
			}
		}
		
	}

	@Override
	public void visit(BlackShot shot) {
		System.out.println("black shot blue chicken");
		
	}
}
