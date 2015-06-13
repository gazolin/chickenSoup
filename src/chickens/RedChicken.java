package chickens;

import javax.swing.ImageIcon;

import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;
import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;

public class RedChicken extends Chicken {

	public RedChicken(Cord cord, ChickenMatrix matrix) {
		super(cord, matrix);	
		this.kind = "red";
		label.setIcon(new ImageIcon("pictures//red.png"));
	}

	@Override
	public void visit(RedShot shot) {
		System.out.println("Red shot red chicken");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		this.die();
	}

	@Override
	public void visit(BlueShot shot) {
		System.out.println("blue shot red chicken");
		
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
	public void visit(YellowShot shot) {
		System.out.println("yellow shot red chicken");
		
		for (int i = 0; i < 2; i++) {
			Chicken chicken = this.matrix.getChickenByKind("orange");
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
		System.out.println("black shot red chicken");
		
	}
}
