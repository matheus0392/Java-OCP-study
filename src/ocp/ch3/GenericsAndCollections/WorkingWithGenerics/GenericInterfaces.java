package ocp.ch3.GenericsAndCollections.WorkingWithGenerics;

public class GenericInterfaces {

	static public void main(String... args) {

	}
}

interface Shippable<T> {
	void ship(T t);
}

//specify the generic type in the class
class ShippableRobotCrate implements Shippable<Robot> {
	public void ship(Robot t) {
	}
}

//create a generic class.
class ShippableAbstractCrate<U> implements Shippable<U> {

	/** static U a; */ // DOES NOT COMPILE
	static String X = "X";

	public void ship(U t) {
		String s;

		/**
			new U();
			U u[] = new U[10];
			if(s instanceof U); new
		 	ShippableAbstractCrate<int>(); */ // DOES NOT COMPILE
	}
}

//not use generics at all
class ShippableCrate implements Shippable {
	public void ship(Object t) {
	}
}