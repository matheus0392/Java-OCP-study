package ocp.ch4.FunctionalProgramming.WorkingWithBuiltInFunctionalInterfaces;

import static java.lang.System.out;
import java.util.Optional;

public class ReturningAnOptional {

	public static void main(String[] args) {

		out.println(average(90, 100)); // Optional[95.0]
		out.println(average()); // Optional.empty

		Optional<Double> opt = average(90, 100);
		// checks whether the Optional actually contains a value
		if (opt.isPresent())
			out.println(opt.get()); // 95.0

		opt = average();
		/** out.println(opt.get()); */ // bad java.util.NoSuchElementException: No value present

		Optional o = Optional.ofNullable(opt);

		opt = average(90, 100);
		opt.ifPresent(System.out::println);

		opt = average();
		// you can return a specific value or variable
		out.println(opt.orElse(Double.NaN));
		// using a Supplier to generate a value at runtime
		out.println(opt.orElseGet(() -> Math.random()));
		// different Supplier to create an exception that should be thrown
		out.println(opt.orElseThrow(() -> new IllegalStateException()));
	}

	static Optional<Double> average(int... scores) {
		if (scores.length == 0)
			return Optional.empty();
		int sum = 0;
		for (int score : scores)
			sum += score;
		return Optional.of((double) sum / scores.length);
	}
}