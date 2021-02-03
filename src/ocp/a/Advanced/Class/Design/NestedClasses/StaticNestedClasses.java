package ocp.a.Advanced.Class.Design.NestedClasses;

import static java.lang.System.*;

public class StaticNestedClasses {

	static class Nested {
		private int price = 6;
	}

	public static void main(String[] args) {
		out.println(new Nested().price); //private member
		out.print(new StaticNestedClasses.Nested().price);
	}

}
