package ocp.ch2.DesignPatternsPrinciples.ImplementingPolymorphism;

import static java.lang.System.*;

//In Java, this allows multiple types of objects to be passed to a single method or class.

//The type of the object determines which properties exist within the object in memory

//The type of the reference to the object determines which methods and variables are accessible to the Java program.

public class ImplementingPolymorphism {

	public static void main(String[] args) {

	}
}

class Primate {
	public boolean hasHair() {
		return true;
	}
}

interface HasTail {
	public boolean isTailStriped();
}

class Lemur extends Primate implements HasTail {
	public int age = 10;

	public boolean isTailStriped() {
		return false;
	}

	public static void main(String[] args) {
		Lemur lemur = new Lemur();
		out.println(lemur.age);
		HasTail hasTail = lemur;
		out.println(hasTail.isTailStriped());
		Primate primate = lemur;
		out.println(primate.hasHair());

		/** out.println(hasTail.age); */ // DOES NOT COMPILE
		/** out.println(primate.isTailStriped()); */ // DOES NOT COMPILE
		
		
		//Casting an object from a subclass to a superclass doesn’t require an explicit cast.
		//Casting an object from a superclass to a subclass requires an explicit cast.
		//The compiler will not allow casts to unrelated types.
		//Even when the code compiles without issue, an exception may be thrown at runtime if the object being cast is not actually an instance of that class.
		primate = lemur;
		/** Lemur lemur2 = primate; */ // DOES NOT COMPILE
		Lemur lemur3 = (Lemur)primate;
		out.println(lemur3.age);
	}
}