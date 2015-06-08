package chickenSoup;

import chickens.Visitor;

public class RedShot implements Shot {

//	@Override
//	public void accept(Chicken chicken) {
//		chicken.visit(this);
//	}

	@Override
	public void shooting(Visitor v) {
		v.visit(this);
	}

}
