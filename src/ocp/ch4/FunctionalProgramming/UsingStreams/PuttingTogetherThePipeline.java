package ocp.ch4.FunctionalProgramming.UsingStreams;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

//Streams allow you to use chaining and express what you want to accomplish rather than how to do so.

public class PuttingTogetherThePipeline {

	public static void main(String[] args) {

		// get the first two names alphabetically that are four characters long
		List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
		
		List<String> filtered = new ArrayList<>();
		for (String name : list) {
			if (name.length() == 4)
				filtered.add(name);
		}
		Collections.sort(filtered);
		Iterator<String> iter = filtered.iterator();
		if (iter.hasNext())
			out.println(iter.next());
		if (iter.hasNext())
			out.println(iter.next());
		
		// In Java 8, the equivalent code is as follows:
		list.stream()
		.filter(n -> n.length() == 4)
		.sorted()
		.limit(2)
		.forEach(out::println);
		
		Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
		infinite.limit(5)
		.peek(out::print)
		.filter(x -> x % 2 == 1)
		.forEach(out::print);
	}

}
