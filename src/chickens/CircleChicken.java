package chickens;

import java.util.Set;

import javax.swing.ImageIcon;

import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;
import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;

public class CircleChicken extends Chicken {
	
	public CircleChicken(Cord cord, ChickenMatrix matrix) {
		super(cord, matrix);
		this.kind = "circle";
		this.label.setIcon(new ImageIcon("pictures//circle.png"));
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
		Set<Chicken> circle = this.matrix.getAllTheChickensAround(cord);
		for (Chicken chicken : circle) {
			if (chicken.isAlive()) {
				chicken.die();
			}
		}
		this.die();
	}

}
