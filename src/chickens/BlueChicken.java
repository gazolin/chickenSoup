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
	public void visit(RedShot shot) {
		for (int i = 0; i < 2; i++) {
			Chicken chicken = this.matrix.getChickenByKind("purple");
			if (chicken != null) {
				chicken.die();
			}
		}
	}

	@Override
	public void visit(BlueShot shot) {
		this.die();
	}

	@Override
	public void visit(YellowShot shot) {
		for (int i = 0; i < 2; i++) {
			Chicken chicken = this.matrix.getChickenByKind("green");
			if (chicken != null) {
				chicken.die();
			}
		}
	}

	@Override
	public void visit(BlackShot shot) {
		
	}
}
