package shots;

import chickens.Visitor;

public class YellowShot implements Shot {

	@Override
	public boolean shooting(Visitor v) {
		return v.visit(this);		
	}

}
