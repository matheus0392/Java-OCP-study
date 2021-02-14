package ocp.ch2.DesignPatternsPrinciples.DesigningAnInterface;

import static java.lang.System.*;

//Interfaces may also not be marked final
interface Fly {
	// abstract
	public int getWingSpan() throws Exception;

	// public static final variables
	public static final int MAX_SPEED = 100;

	public default void land() {
		out.println("Animal is landing");
	}

	public static double calculateSpeed(float distance, double time) {
		return distance / time;
	}
}

class Eagle implements Fly {
	public int getWingSpan() {
		return 15;
	}

	public void land() {
		out.println("Eagle is diving fast");
	}
}

interface Walk {
	boolean isQuadruped();

	abstract double getMaxSpeed();
}

//An interface may extend another interface
interface Run extends Walk {
	public abstract boolean canHuntWhileRunning();

	// interface method definitions may be duplicated
	abstract double getMaxSpeed();
}

class Lion implements Run {
	public boolean isQuadruped() {
		return true;
	}

	public boolean canHuntWhileRunning() {
		return true;
	}

	public double getMaxSpeed() {
		return 100;
	}
}

/** interface Sleep extends Lion {} */ // DOES NOT COMPILE
/** class Tiger extends Walk {} */ // DOES NOT COMPILE

interface Swim {
	public default void action() {
		out.println("swim");
	}
}

interface Hop {
	public default void action() {
		out.println("Hop");
	}
}

// as a class may implement multiple interfaces
class Frog implements Swim, Hop {

	// must implement default method with same signature from multiples interfaces
	@Override
	public void action() {
		Swim.super.action();
		Hop.super.action();
	}
}

//An interface may extend anothers interfaces
class InterfacesWithSameMethod {

	private interface CanWalk {
		default void walk() {
			System.out.println("Walking");
		}

		public void run();
	}

	private interface CanRun {
		public default void walk() {
			System.out.println("Walking");
		}

		public void run();
	}

	private interface CanSprint extends CanWalk, CanRun {
		// must implement default method with same signature from multiples interfaces
		// even in one another interface
		public default void walk() {
			System.out.println("Walking");
		}

		public void run(); // optional
	}
}