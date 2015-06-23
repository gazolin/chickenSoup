package chickens;

import java.util.Set;

import javax.swing.ImageIcon;

import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;
import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;

public class ExChicken extends Chicken {
	
	public ExChicken(Cord cord, ChickenMatrix matrix) {
		super(cord, matrix);
		this.kind = "ex";
		this.label.setIcon(new ImageIcon("pictures//ex.png"));
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
		Set<Chicken> ex = this.matrix.getChickensInEx(cord);
		for (Chicken chicken : ex) {
			if (chicken.isAlive()) {
				chicken.die();
			}
		}
		this.die();		
		return true;
	}

}
