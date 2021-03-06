package ocp.ch4.FunctionalProgramming.UsingStreams;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class UsingCommonIntermediateOperations {

	// intermediate operations deal with infinite streams simply by returning an infinite stream

	public static void main(String[] args) {

		// Stream<T> filter(Predicate<? super T> predicate)

		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		s.filter(x -> x.startsWith("m")).forEach(out::println); // monkey

		// Stream<T> distinct()
		// Java calls equals() to determine whether the objects are the same.

		s = Stream.of("duck", "duck", "duck", "goose");
		s.distinct().forEach(out::print); // duckgoose
		out.println();

		// Stream<T> limit(int maxSize)
		// Stream<T> skip(int n)

		Stream<Integer> i = Stream.iterate(1, n -> n + 1);
		i.skip(5).limit(2).forEach(out::print); // 67
		out.println();

		// <R> Stream<R> map(Function<? super T, ? extends R> mapper)

		s = Stream.of("monkey", "gorilla", "bonobo");
		s.map(String::length).forEach(out::print); // 676
		out.println();

		// <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>>
		// mapper)

		List<String> zero = Arrays.asList();
		List<String> one = Arrays.asList("Bonobo");
		List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
		Stream<List<String>> animals = Stream.of(zero, one, two);
		animals.flatMap(l -> l.stream()).forEach(out::println);

		// Stream<T> sorted()
		// Stream<T> sorted(Comparator<? super T> comparator)

		s = Stream.of("brown-", "bear-");
		s.sorted().forEach(out::print); // bear-brown
		out.println();

		s = Stream.of("brown bear-", "grizzly-");
		s.sorted(Comparator.reverseOrder()).forEach(out::print); // grizzly-brown bear-
		out.println();
		/** s.sorted(Comparator::reverseOrder); */ // DOES NOT COMPILE

		// Stream<T> peek(Consumer<? super T> action)

		Stream<String> stream = Stream.of("black bear", "brown bear", "grizzly");
		long count = stream.filter(ss -> ss.startsWith("g")).peek(out::println).count(); // grizzly
		out.println(count); // 1

	}

}
