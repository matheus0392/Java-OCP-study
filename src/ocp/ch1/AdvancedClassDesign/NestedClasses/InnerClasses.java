package ocp.ch1.AdvancedClassDesign.NestedClasses;

import static java.lang.System.*;

public class InnerClasses {

	private String greeting = "Hi";

	// Member Inner Classes
	// Can access members of the outer class including private members
	// Can be declared public, private, or protected or use default access
	protected class Inner {
		public int repeat = 3;

		public void go() {
			for (int i = 0; i < repeat; i++)
				out.println(greeting);
		}
	}

	public void callInner() {
		Inner inner = new Inner();
		inner.go();
	}

	public static void main(String[] args) {
		InnerClasses outer = new InnerClasses();
		outer.callInner();

		Inner inner = outer.new Inner(); // create the inner class
		inner.go();
	}
}

class A {
	private int x = 10;

	class B {
		private int x = 20;

		class C {
			private int x = 30;

			public void allTheX() {
				out.println(x); // 30
				out.println(this.x); // 30
				out.println(B.this.x); // 20
				out.println(A.this.x); // 10
			}
		}
	}

	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B();
		A.B.C c = b.new C();
		c.allTheX();
	}
}

//private interface
class CaseOfThePrivateInterface {
	private interface Secret {
		public void shh();
	}

	class DontTell implements Secret {
		public void shh() {
		}
	}
}