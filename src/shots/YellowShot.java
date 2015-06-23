package shots;

import chickens.Visitor;

public class YellowShot implements Shot {

	@Override
	public void shooting(Visitor v) {
		v.visit(this);
	}

}
