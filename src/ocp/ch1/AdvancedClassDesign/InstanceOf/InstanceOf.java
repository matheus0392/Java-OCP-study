package ocp.ch1.AdvancedClassDesign.InstanceOf;

//Make sure that they are importing static methods or variables rather than class names.
import static java.lang.System.*;

interface Mother {

}

class HeavyAnimal {
}

class Hippo extends HeavyAnimal {
}

class Elephant extends HeavyAnimal implements Mother {
}

public class InstanceOf {
	public static void main(String[] args) {
		HeavyAnimal hippo = new Hippo();
		boolean b1 = hippo instanceof Hippo; // true
		boolean b2 = hippo instanceof HeavyAnimal; // true
		boolean b3 = hippo instanceof Elephant; // false

		out.println(String.format("%b %b %b", b1, b2, b3));

		HeavyAnimal heavyAnimal = new HeavyAnimal();
		b1 = heavyAnimal instanceof Hippo; // false
		b2 = heavyAnimal instanceof HeavyAnimal; // true
		b3 = heavyAnimal instanceof Elephant; // false

		out.println(String.format("%b %b %b", b1, b2, b3));

		boolean b4 = hippo instanceof Object; // true
		Hippo nullHippo = null;
		boolean b5 = nullHippo instanceof Object; // false
		boolean b5_1 = nullHippo instanceof Hippo; // false
		//If the literal null or a variable reference pointing to null is used to check instanceof, the result is false

		out.println(String.format("%b %b %b", b4, b5, b5_1));

		@SuppressWarnings("unused")
		Hippo anotherHippo = new Hippo();
		/** boolean b5 = anotherHippo instanceof Elephant; **/  // DOES NOT COMPILE
		//The compiler knows that there is no possible way for a Hippo variable reference to be an Elephant

		hippo = new Hippo();
		boolean b6 = hippo instanceof Mother;
		HeavyAnimal eleph = new Elephant();
		boolean b7 = eleph instanceof Mother;
		// When checking whether an object is an instanceof an interface, Java waits until runtime to do the check

		out.println(String.format("%b %b", b6, b7));
	}
}
