package ocp.ch4.FunctionalProgramming.UsingStreams;

import static java.lang.System.out;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsingCommonTerminalOperations {

	public static void main(String[] args) {

		// long count()
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		out.println(s.count()); // 3

		// Optional<T> min(<? super T> comparator)
		// Optional<T> max(<? super T> comparator)

		s = Stream.of("monkey", "ape", "bonobo");
		Optional<String> min = s.min((s1, s2) -> s1.length() - s2.length());
		min.ifPresent(out::println); // ape

		// Since the stream is empty, the comparator is never called
		Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
		out.println(minEmpty.isPresent()); // false

		// Optional<T> findAny()
		// Optional<T> findFirst()
		
		// terminal operations but not reductions

		s = Stream.of("monkey", "gorilla", "bonobo");
		Stream<String> infinite = Stream.generate(() -> "chimp");
		s.findAny().ifPresent(out::println); // monkey
		infinite.findFirst().ifPresent(out::println); // chimp
		
		// boolean anyMatch(Predicate <? super T> predicate)
		// boolean allMatch(Predicate <? super T> predicate)
		// boolean noneMatch(Predicate <? super T> predicate)
		
		// These may or may not terminate for infinite streams
		
		List<String> list = Arrays.asList("monkey", "2", "chimp");
		infinite = Stream.generate(() -> "chimp");
		Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
		out.println(list.stream().anyMatch(pred)); // true
		out.println(list.stream().allMatch(pred)); // false
		out.println(list.stream().noneMatch(pred)); // false
		out.println(infinite.anyMatch(pred)); // true

		// void forEach(Consumer<? super T> action)
		
		s = Stream.of("Monkey", "Gorilla", "Bonobo");
		s.forEach(out::print); // MonkeyGorillaBonobo
		out.println();
		
		Stream ss = Stream.of(1);
		/** for (Integer i: ss) {} */ // DOES NOT COMPILE

		// T reduce(T identity, BinaryOperator<T> accumulator)
		// Optional<T> reduce(BinaryOperator<T> accumulator)
		// <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
		
		// combines a stream into a single object
		
		Stream<String> stream = Stream.of("w", "o", "l", "f");
		String word = stream.reduce("", (b, c) -> b + c);
		out.println(word); // wolf
		
		Stream<Integer> stream2 = Stream.of(3, 5, 6);
		out.println(stream2.reduce(1, (a, b) -> a*b));
		
		BinaryOperator<Integer> op = (a, b) -> a * b;
		Stream<Integer> empty = Stream.empty();
		Stream<Integer> oneElement = Stream.of(3);
		Stream<Integer> threeElements = Stream.of(3, 5, 6);
		empty.reduce(op).ifPresent(out::println); // no output
		oneElement.reduce(op).ifPresent(out::println); // 3
		threeElements.reduce(op).ifPresent(out::println); // 90

		threeElements = Stream.of(3, 5, 6);
		out.println(threeElements.reduce(1, op, op)); // 90
		
		// <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)
		// <R,A> R collect(Collector<? super T, A,R> collector)
		
		stream = Stream.of("w", "o", "l", "f");
		StringBuilder word2 = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		out.println(word2);
		
		stream = Stream.of("w", "o", "l", "f");
		TreeSet<String> set = stream.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
		out.println(set); // [f, l, o, w]
		
		stream = Stream.of("w", "o", "l", "f");
		set = stream.collect(Collectors.toCollection(TreeSet::new));
		out.println(set); // [f, l, o, w]
		
		stream = Stream.of("w", "o", "l", "f");
		Set<String> set2 = stream.collect(Collectors.toSet());
		out.println(set2); // [f, w, l, o]
	}

}
