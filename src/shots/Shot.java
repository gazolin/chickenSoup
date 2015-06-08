package shots;

import chickens.Visitor;

public interface Shot {
//	public void accept(Chicken chicken);
	
	//can it be Chicken chicken?
	public void shooting(Visitor v);
}
