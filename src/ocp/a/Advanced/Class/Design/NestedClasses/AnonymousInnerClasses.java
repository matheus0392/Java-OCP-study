package ocp.a.Advanced.Class.Design.NestedClasses;

import static java.lang.System.*;

public class AnonymousInnerClasses {

	abstract class SaleTodayOnly {
		abstract int dollarsOff();
	}

	public int admission(int basePrice) {
		// It is declared and instantiated all in one statement using the new keyword.
		SaleTodayOnly sale = new SaleTodayOnly() {
			int dollarsOff() {
				return 3;
			}
		};// semicolon
		return basePrice - sale.dollarsOff();
	}

	interface SaleTodayOnly2 {
		int dollarsOff();
	}

	public int admission2(int basePrice) {
		// You can’t implement both an interface and extend a class
		SaleTodayOnly2 sale = new SaleTodayOnly2() {
			public int dollarsOff() {
				return 3;
			}
		};
		return basePrice - sale.dollarsOff();
	}


	public int admission3(int basePrice, SaleTodayOnly sale) {
		return basePrice - sale.dollarsOff();
	}
	public int admission4(int basePrice, SaleTodayOnly2 sale) {
		return basePrice - sale.dollarsOff();
	}


	public static void main(String[] args) {
		out.println(new AnonymousInnerClasses().admission(10));
		out.println(new AnonymousInnerClasses().admission2(10));
		out.println(new AnonymousInnerClasses().admission3(10, new AnonymousInnerClasses().new SaleTodayOnly() {
			public int dollarsOff() {
				return 3;
			}
		}));
		out.println(new AnonymousInnerClasses().admission4(10, new SaleTodayOnly2() {
			public int dollarsOff() {
				return 3;
			}
		}));
	}
}
