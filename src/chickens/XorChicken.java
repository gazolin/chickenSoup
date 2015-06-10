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
		this.button.setIcon(new ImageIcon("xor.png"));
	}

	@Override
	public void visit(RedShot shot) {
		System.out.println("Red shot xor chicken");
		
	}

	@Override
	public void visit(BlueShot shot) {
		System.out.println("blue shot xor chicken");
		
	}

	@Override
	public void visit(YellowShot shot) {
		System.out.println("yellow shot xor chicken");
		
	}
	
	@Override
	public void visit(BlackShot shot) {
		System.out.println("black shot xor chicken");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
