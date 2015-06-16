package shots;

import chickens.Visitor;

public class BlueShot extends Shot {

	@Override
	public void shooting(Visitor v) {
		v.visit(this);
	}

}
