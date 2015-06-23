package chickens;

import java.util.Set;

import javax.swing.ImageIcon;

import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;
import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;

public class FluChicken extends Chicken {
	
	public FluChicken(Cord cord, ChickenMatrix matrix) {
		super(cord, matrix);
		this.kind = "flu";
		this.label.setIcon(new ImageIcon("pictures//flu.png"));
	}

	@Override
	public boolean visit(RedShot shot) {
		return false;
	}

	@Override
	public boolean visit(BlueShot shot) {
		return false;
	}

	@Override
	public boolean visit(YellowShot shot) {
		return false;
	}
	
	@Override
	public boolean visit(BlackShot shot) {
		Set<Chicken> chickens = this.matrix.getAllChickenSet();
		for (Chicken chicken : chickens) {
			if (chicken.isAlive()) {
				chicken.die();
			}
		}
		return true;
	}

}
