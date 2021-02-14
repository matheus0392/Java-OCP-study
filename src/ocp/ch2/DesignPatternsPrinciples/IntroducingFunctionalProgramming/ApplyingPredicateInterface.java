package ocp.ch2.DesignPatternsPrinciples.IntroducingFunctionalProgramming;

import java.util.function.Predicate;
import static java.lang.System.*;

public class ApplyingPredicateInterface {

	// The result of using Predicate is that we no longer need our own functional interface.
	private static void print(Animal animal, Predicate<Animal> trait) {
		if (trait.test(animal))
			out.println(animal);
	}

	public static void main(String[] args) {
		print(new Animal("fish", false, true), a -> a.canHop());
		print(new Animal("kangaroo", true, false), a -> a.canHop());
	}
}
