package chickens;

import javax.swing.ImageIcon;

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
		label.setIcon(new ImageIcon("pictures//blue.png"));
	}
	
	@Override
	public boolean visit(RedShot shot) {
		boolean died = false;
		for (int i = 0; i < 2; i++) {
			Chicken chicken = this.matrix.getChickenByKind("purple");
			if (chicken != null) {
				chicken.die();
				died = true;
			}
		}
		return died;
	}

	@Override
	public boolean visit(BlueShot shot) {
		this.die();
		return true;
	}

	@Override
	public boolean visit(YellowShot shot) {
		boolean died = false;
		for (int i = 0; i < 2; i++) {
			Chicken chicken = this.matrix.getChickenByKind("green");
			if (chicken != null) {
				chicken.die();
				died = true;
			}
		}
		return died;
	}

	@Override
	public boolean visit(BlackShot shot) {
		return false;
	}
}
