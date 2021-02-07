package ocp.ch1.AdvancedClassDesign.Enum;

import static java.lang.System.*;

enum Season {
	// they are like static final constants
	// we have a semicolon. This is required if there is anything in the enum
	// besides the values.
	/*WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");

	 //The constructor is private because it can only be called from within the enum
	 //The constructors are required to be private or package private
	Season(String expectedVisitors) {
		this.expectedVisitors = expectedVisitors;
	}
	 */

	/*WINTER {
		public void printHours() {
			System.out.println("9am-3pm");
		}
	},
	SPRING {
		public void printHours() {
			System.out.println("9am-5pm");
		}
	},
	SUMMER {
		public void printHours() {
			System.out.println("9am-7pm");
		}
	},
	FALL {
		public void printHours() {
			System.out.println("9am-5pm");
		}
	};

	public abstract void printHours();
	 */

	WINTER {
		public void printHours() {
			System.out.println("short hours");
		}
	},
	SUMMER {
		public void printHours() {
			System.out.println("long hours");
		}
	},
	SPRING, FALL;

	public void printHours() {
		System.out.println("default hours");
	}

	private String expectedVisitors;

	// a method
	public void printExpectedVisitors() {
		out.println(expectedVisitors);
	}

	Enum enum_; //Enums are allowed to have instance variables
}

enum OnlyOne {
	ONCE(true);

	private OnlyOne(boolean b) {
		// The first time that we ask for any of the enum values, Java constructs all of
		// the enum values.
		System.out.println("constructing");
	}

	public static void main(String[] args) {
		OnlyOne firstCall = OnlyOne.ONCE; // prints constructing
		OnlyOne secondCall = OnlyOne.ONCE; // doesn't print anything
	}
}

//Another thing that you can’t do is extend an enum.
/** public enum ExtendedSeason extends Season { } **/ // DOES NOT COMPILE

public class Enum {
	public static void main(String[] args) {

		Season s = Season.SUMMER;
		out.println(Season.SUMMER); // SUMMER
		out.println(s == Season.SUMMER); // true

		// values()
		for (Season season : Season.values()) {
			System.out.println(season.name() + " " + season.ordinal());
		}

		// an enum is a type and not an int.
		/** if ( Season.SUMMER == 2) {} **/ // DOES NOT COMPILE

		// Enums may be used in switch statements.
		Season summer = Season.SUMMER;
		switch (summer) {
		case WINTER:
			System.out.println("Get out the sled!");
			break;
		case SUMMER:
			System.out.println("Time for the pool!");
			break;
		default:
			System.out.println("Is it summer yet?");
		}

		// You can't compare an int with an enum.
		switch (summer) {
		/** case 0: System.out.println("Get out the sled!"); break; **/ // DOES NOT COMPILE
		}

		Season.SUMMER.printExpectedVisitors();
		Season.SUMMER.printHours();

		// You can also create an enum from a String.
		Season s1 = Season.valueOf("SUMMER"); // SUMMER
		Season s2 = Season.valueOf("summer"); // exception

	}

}
