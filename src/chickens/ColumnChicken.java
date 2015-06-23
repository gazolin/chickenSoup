package chickens;

import java.util.Set;

import javax.swing.ImageIcon;

import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;
import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;

public class ColumnChicken extends Chicken {
	
	public ColumnChicken(Cord cord, ChickenMatrix matrix) {
		super(cord, matrix);
		this.kind = "column";
		this.label.setIcon(new ImageIcon("pictures//column.png"));
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
		int j = this.cord.getJ();
		Set<Chicken> col = this.matrix.getChickensInCol(j);
		for (Chicken chicken : col) {
			if (chicken.isAlive()) {
				chicken.die();
			}
		}
		return true;
	}

}
