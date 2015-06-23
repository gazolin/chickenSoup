package shots;

import chickens.Visitor;

public class BlueShot implements Shot {

	@Override
	public void shooting(Visitor v) {
		v.visit(this);
	}

}
