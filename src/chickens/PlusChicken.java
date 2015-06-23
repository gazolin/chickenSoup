package chickens;

import java.util.Set;

import javax.swing.ImageIcon;

import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;
import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;

public class PlusChicken extends Chicken {
	
	public PlusChicken(Cord cord, ChickenMatrix matrix) {
		super(cord, matrix);
		this.kind = "plus";
		this.label.setIcon(new ImageIcon("pictures//plus.png"));
	}

	@Override
	public void visit(RedShot shot) {
		
	}

	@Override
	public void visit(BlueShot shot) {
		
	}

	@Override
	public void visit(YellowShot shot) {
		
	}
	
	@Override
	public void visit(BlackShot shot) {
		Set<Chicken> plus = this.matrix.getChickensInRow(cord.getI());
		plus.addAll(this.matrix.getChickensInCol(cord.getJ()));
		
		for (Chicken chicken : plus) {
			if (chicken.isAlive()) {
				chicken.die();
			}
		}
	}

}
