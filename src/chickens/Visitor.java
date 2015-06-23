package chickens;

import shots.BlackShot;
import shots.BlueShot;
import shots.RedShot;
import shots.YellowShot;

public interface Visitor {
	
	public boolean visit(RedShot shot);
	public boolean visit(BlackShot shot);
	public boolean visit(BlueShot shot);
	public boolean visit(YellowShot shot);

}
