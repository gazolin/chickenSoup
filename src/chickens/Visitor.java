package chickens;

import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;

public interface Visitor {
	
	public void visit(RedShot shot);
	public void visit(BlackShot shot);
	public void visit(BlueShot shot);
	public void visit(YellowShot shot);

}
