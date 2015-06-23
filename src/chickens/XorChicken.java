package chickens;

import java.util.Set;

import javax.swing.ImageIcon;

import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;
import chickenSoup.ChickenMatrix;
import chickenSoup.Cord;

public class XorChicken extends Chicken {
	
	public XorChicken(Cord cord, ChickenMatrix matrix) {
		super(cord, matrix);
		this.kind = "xor";
		this.label.setIcon(new ImageIcon("pictures//xor.png"));
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
		Set<Chicken> xor = this.matrix.getChickensInRow(cord.getI());
		xor.addAll(this.matrix.getChickensInCol(cord.getJ()));
		xor.addAll(this.matrix.getAllTheChickensAround(cord));
		
		for (Chicken chicken : xor) {
			if (chicken.isAlive()) {
				chicken.die();
			}
		}	
	}

}
