package ocp.ch1.AdvancedClassDesign.NestedClasses;

import static java.lang.System.*;

public class StaticNestedClasses {

	private int value;

	private static int value2;

	//Static nested classes can exist without an instance of the outer class.
	static class Nested {
		private int price = 6;

		static public void m() {
			/** out.println(value);**/ //DOES NOT COMPILE
			out.println(value2);
		}
	}

	//Static nested classes cannot access the enclosing class instancevariables
	public static void main(String[] args) {
		out.println(new Nested().price); //private member
		out.println(new StaticNestedClasses.Nested().price);
		Nested.m();
	}

}
