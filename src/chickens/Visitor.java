package chickens;

import chickenSoup.BlackShot;
import chickenSoup.RedShot;

public interface Visitor {
	
	public void visit(RedShot shot);
	public void visit(BlackShot shot);

}
