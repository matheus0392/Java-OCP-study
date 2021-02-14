package ocp.ch2.DesignPatternsPrinciples.IntroducingFunctionalProgramming;

//a lambda expression is a block of code that gets passed around,
public class ImplementingFunctionalInterfacesWithLambdas {
	private static void print(Animal animal, CheckTrait trait) {
		if (trait.test(animal))
			System.out.println(animal);
	}

	public static void main(String[] args) {
		print(new Animal("fish", false, true), a -> a.canHop());
		print(new Animal("kangaroo", true, false), a -> a.canHop());
		print(new Animal("kangaroo", true, false), (Animal a) -> {return a.canHop();});
		
		/** Duck d -> d.quack(); */						// DOES NOT COMPILE
		/** a,d -> d.quack(); */						// DOES NOT COMPILE
		/** Animal a, Duck d -> d.quack(); */			// DOES NOT COMPILE
		/**(int y, z) -> {int x=1; return y+10; } */	// DOES NOT COMPILE
		/** (a, b) -> { int a = 0; return 5;} */		// DOES NOT COMPILE

	}
}

class Animal {
	private String species;
	private boolean canHop;
	private boolean canSwim;

	public Animal(String speciesName, boolean hopper, boolean swimmer) {
		species = speciesName;
		canHop = hopper;
		canSwim = swimmer;
	}

	public boolean canHop() {
		return canHop;
	}

	public boolean canSwim() {
		return canSwim;
	}

	public String toString() {
		return species;
	}
}

interface CheckTrait {
	public boolean test(Animal a);
}