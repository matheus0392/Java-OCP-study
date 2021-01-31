package ocp.a.Advanced.Class.Design.AnnotatingOverriddenMethods;

import static java.lang.System.*;

class Bobcat {
	public void findDen() {
	}
}

class BobcatMother extends Bobcat {
	@Override //this line tells Java that the method intended to override another method
	public void findDen() {
	}

	/** @Override 
	 public void findDen(boolean b) { }**/ // DOES NOT COMPILE
	//Java recognizes that this is a broken promise and gives it a compiler error.
}

public class AnnotatingOverriddenMethods {
	public static void main(String[] args) {

	}
}
