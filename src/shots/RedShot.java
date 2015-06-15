package shots;

import chickens.Visitor;

public class RedShot extends Shot {

	@Override
	public void shooting(Visitor v) {
		v.visit(this);
	}

}
