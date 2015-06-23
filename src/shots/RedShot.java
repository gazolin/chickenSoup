package shots;

import chickens.Visitor;

public class RedShot implements Shot {

	@Override
	public boolean shooting(Visitor v) {
		return v.visit(this);		
	}

}
