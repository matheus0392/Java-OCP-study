package ocp.ch4.FunctionalProgramming.WorkingWithPrimitives;

import static java.lang.System.out;
import java.util.function.BooleanSupplier;

public class LearningFunctionalInterfacesForPrimitives {

	public static void main(String[] args) {

		// boolean getAsBoolean()

		BooleanSupplier b1 = () -> true;
		BooleanSupplier b2 = () -> Math.random() > .5;
		out.println(b1.getAsBoolean());
		out.println(b2.getAsBoolean());
	}

}
