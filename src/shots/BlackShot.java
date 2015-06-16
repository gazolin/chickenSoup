package shots;

import chickens.Visitor;

public class BlackShot extends Shot {

	@Override
	public void shooting(Visitor v) {
		v.visit(this);		
	}

}
