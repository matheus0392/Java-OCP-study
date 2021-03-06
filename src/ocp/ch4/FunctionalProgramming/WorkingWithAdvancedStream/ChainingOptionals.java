package ocp.ch4.FunctionalProgramming.WorkingWithAdvancedStream;

import static java.lang.System.out;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ChainingOptionals {

	public static void main(String[] args) {

		Optional<Integer> optional = Stream.of(1, 222, 3222, 422, 522).filter(x -> x > 2).findFirst();
		optional.map(n -> "" + n) // part 1
				.filter(s -> s.length() == 3) // part 2
				.ifPresent(out::println); // part 3

		try {
			ExceptionCaseStudy.create().stream().count();
		} catch (IOException e) {
			out.println("IOException");
		}

		/** Supplier<List<String>> s = ExceptionCaseStudy::create; */ // DOES NOT COMPILE

		Supplier<List<String>> s2 = ExceptionCaseStudy::createSafe;
	}

}

class ExceptionCaseStudy {
	public static List<String> create() throws IOException {
		throw new IOException();
	}

	public static List<String> createSafe() {
		try {
			return ExceptionCaseStudy.create();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
