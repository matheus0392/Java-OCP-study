package ocp.ch4.FunctionalProgramming.WorkingWithBuiltInFunctionalInterfaces;

import static java.lang.System.out;

import java.util.function.BiFunction;
import java.util.function.Function;

/*
	@FunctionalInterface public class Predicate<T> {
		boolean test(T t);
	}
	@FunctionalInterface public class BiPredicate<T, U> {
		boolean test(T t, U u);
	}
*/

public class ImplementingPredicateAndBiPredicate {

	public static void main(String[] args) {

		// The types don’t have to be different
		Function<String, Integer> f1 = String::length;
		Function<String, Integer> f2 = x -> x.length();
		out.println(f1.apply("cluck")); // 5
		out.println(f2.apply("cluck")); // 5
		
		BiFunction<String, String, String> b1 = String::concat;
		BiFunction<String, String, String> b2 = (string, toAdd) -> string.concat(toAdd);
		out.println(b1.apply("baby ", "chick")); // baby chick
		out.println(b2.apply("baby ", "chick")); // baby chick
	}

}
