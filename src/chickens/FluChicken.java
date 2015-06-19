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
	public void visit(RedShot shot) {
		System.out.println("Red shot flu chicken");
		
	}

	@Override
	public void visit(BlueShot shot) {
		System.out.println("blue shot flu chicken");
		
	}

	@Override
	public void visit(YellowShot shot) {
		System.out.println("yellow shot flu chicken");
		
	}
	
	@Override
	public void visit(BlackShot shot) {
		System.out.println("black shot flu chicken");
	
		
		Set<Chicken> chickens = this.matrix.getAllChickenSet();
		for (Chicken chicken : chickens) {
			if (chicken.isAlive()) {
				chicken.die();
			}
		}
		
	}

}
