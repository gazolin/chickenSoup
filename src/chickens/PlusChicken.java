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
		this.button.setIcon(new ImageIcon("plus.png"));
	}

	@Override
	public void visit(RedShot shot) {
		System.out.println("Red shot plus chicken");
		
	}

	@Override
	public void visit(BlueShot shot) {
		System.out.println("blue shot plus chicken");
		
	}

	@Override
	public void visit(YellowShot shot) {
		System.out.println("yellow shot plus chicken");
		
	}
	
	@Override
	public void visit(BlackShot shot) {
		System.out.println("black shot plus chicken");
		
		Set<Chicken> plus = this.matrix.getChickensInRow(cord.getI());
		plus.addAll(this.matrix.getChickensInCol(cord.getJ()));
		
		for (Chicken chicken : plus) {
			if (chicken.isAlive()) {
				chicken.die();
			}
		}
		
	}

}
