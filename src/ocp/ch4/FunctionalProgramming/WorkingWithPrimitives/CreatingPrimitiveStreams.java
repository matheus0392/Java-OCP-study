package ocp.ch4.FunctionalProgramming.WorkingWithPrimitives;

import static java.lang.System.out;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreatingPrimitiveStreams {

	public static void main(String[] args) {

		DoubleStream empty = DoubleStream.empty();

		DoubleStream oneValue = DoubleStream.of(3.14);

		DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2);

		oneValue.forEach(out::println);
		out.println();
		varargs.forEach(out::println);

		DoubleStream random = DoubleStream.generate(Math::random);
		DoubleStream fractions = DoubleStream.iterate(.5, d -> d / 2);
		random.limit(3).forEach(out::println);
		out.println();
		fractions.limit(3).forEach(out::println);
		new Random().ints();

		IntStream range = IntStream.range(1, 6);
		range.forEach(out::println);

		IntStream rangeClosed = IntStream.rangeClosed(1, 5);
		rangeClosed.forEach(System.out::println);

		// Mapping methods between types of streams

		Stream<String> objStream = Stream.of("penguin", "fish");
		IntStream intStream = objStream.mapToInt(s -> s.length());
		objStream = Stream.of("penguin", "fish");
		IntStream ints =objStream.flatMapToInt(x -> IntStream.of(x.length()));
		
		
		
	}

}
