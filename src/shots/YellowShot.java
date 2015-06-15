package shots;

import chickens.Visitor;

public class YellowShot extends Shot {

	@Override
	public void shooting(Visitor v) {
		v.visit(this);
	}

}
