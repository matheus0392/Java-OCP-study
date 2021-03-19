package ocp.ch7.Concurrency.WorkingWithParallelStreams;

import static java.lang.System.out;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessingParallelReductions {

	public static void main(String[] args) {
		// Performing Order-Based Tasks
		out.println(Arrays.asList(1,2,3,4,5,6).stream().findAny().get());
		out.println(Arrays.asList(1,2,3,4,5,6).parallelStream().findAny().get());
		
		out.println(Arrays.asList(1,2,3,4,5,6).stream().skip(2).limit(2).findFirst());
		out.println(Arrays.asList(1,2,3,4,5,6).parallelStream().skip(2).limit(2).findFirst());
		out.println();
		//Combining Results with reduce()
		
		//Let’s take a look at an example using a non-associative
		out.println(Arrays.asList(1,2,3,4,5,6)
				.parallelStream()
				.reduce(0,(a,b) -> (a-b))); // NOT AN ASSOCIATIVE ACCUMULATOR
		
		out.println(Arrays.asList("w","o","l","f")
				.parallelStream()
				.reduce("X",String::concat));// the identity is applied to multiple elements in the stream
		out.println();
		
		//Combing Results with collect()
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
		ConcurrentMap<Integer, String> map = ohMy
		.collect(Collectors.toConcurrentMap(String::length, k -> k,
				(s1, s2) -> s1 + "," + s2));
		out.println(map); // {5=lions,bears, 6=tigers}
		out.println(map.getClass()); // java.util.concurrent.ConcurrentHashMap
		
		ohMy = Stream.of("lions", "tigers", "bears").parallel();
		ConcurrentMap<Integer, List<String>> map2 = ohMy.collect(
		Collectors.groupingByConcurrent(String::length));
		System.out.println(map2); // {5=[lions, bears], 6=[tigers]}
	}

}
