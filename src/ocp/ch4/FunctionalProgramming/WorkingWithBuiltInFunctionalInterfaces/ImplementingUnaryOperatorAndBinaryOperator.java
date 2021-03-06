package ocp.ch4.FunctionalProgramming.WorkingWithBuiltInFunctionalInterfaces;

import static java.lang.System.out;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/*
@FunctionalInterface public class UnaryOperator<T> extends Function<T, T> {}

@FunctionalInterface public class BinaryOperator<T> extends BiFunction<T, T, T> {}

*/
public class ImplementingUnaryOperatorAndBinaryOperator {

	public static void main(String[] args) {

		UnaryOperator<String> u1 = String::toUpperCase;
		UnaryOperator<String> u2 = x -> x.toUpperCase();
		out.println(u1.apply("chirp"));
		out.println(u2.apply("chirp"));
		
		
		BinaryOperator<String> b1 = String::concat;
		BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);
		out.println(b1.apply("baby ", "chick")); // baby chick
		out.println(b2.apply("baby ", "chick")); // baby chick
	}

}
