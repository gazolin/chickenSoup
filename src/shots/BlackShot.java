package shots;

import chickens.Visitor;

public class BlackShot implements Shot {
	
	@Override
	public void shooting(Visitor v) {
		v.visit(this);		
	}

}
