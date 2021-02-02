package ocp.a.Advanced.Class.Design.NestedClasses;

import static java.lang.System.*;

public class LocalInnerClasses {
	private int length = 5;

	public void calculate() {
		final int width = 20;

		//effectively final.
		int width2= 20;
		
		// not effectively final.
		int width3= 20;
		width3 ++;

		// They do not have an access specifier
		// They cannot be declared static and cannot declare static fields or methods.
		// They have access to all fields and methods of the enclosing class.
		// They do not have access to local variables of a method unless those variables
		// are final or effectively final.
		class Inner {
			public void multiply() {
				out.println(length * width* width2);
			}
		}
		Inner inner = new Inner();
		inner.multiply();
	}

	public static void main(String[] args) {
		LocalInnerClasses outer = new LocalInnerClasses();
		outer.calculate();
	}
}