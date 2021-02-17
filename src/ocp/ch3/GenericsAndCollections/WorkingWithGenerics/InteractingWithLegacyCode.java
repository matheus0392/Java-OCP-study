package ocp.ch3.GenericsAndCollections.WorkingWithGenerics;

import java.util.ArrayList;
import java.util.List;
import static java.lang.System.*;

public class InteractingWithLegacyCode {
	static public void main(String... args) {

	}
}

class Dragon {
}

class Unicorn {
}

class LegacyDragons {
	public static void main(String[] args) {
		List unicorns = new ArrayList();
		unicorns.add(new Unicorn());
		printDragons(unicorns);
	}

	private static void printDragons(List<Dragon> dragons) {
		// With generic types, Java writes the casts for us
		// The cast is tricky because it doesn’t appear in the code
		for (Dragon dragon : dragons) { // ClassCastException
			out.println(dragon);
		}
	}
}

class LegacyUnicorns {
	public static void main(String[] args) {
		java.util.List<Unicorn> unicorns = new java.util.ArrayList<>();
		addUnicorn(unicorns);
		Unicorn unicorn = unicorns.get(0); // ClassCastException
	}

	private static void addUnicorn(List unicorn) {
		unicorn.add(new Dragon());
	}
}

class LegacyAutoboxing {
	public static void main(String[] args) {
		List numbers = new ArrayList();
		//Java automatically autoboxes to an Integer.
		numbers.add(5);
		//It just knows that we have an Object. And an Object can’t be unboxed into an int
		/***int result = numbers.get(0); */ // DOES NOT COMPILE
	}
}