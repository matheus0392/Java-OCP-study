package ocp.ch4.FunctionalProgramming.WorkingWithAdvancedStream;

import static java.lang.System.out;
import static java.util.stream.Collectors.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {


	public static void main(String[] args) {
		Stream<String> ohMy;
		
		ohMy = Stream.of("lions", "tigers", "bears");
		String result = ohMy.collect(Collectors.joining(", "));
		out.println(result); // lions, tigers, bears

		ohMy = Stream.of("lions", "tigers", "bears");
		Double result2 = ohMy.collect(Collectors.averagingInt(String::length));
		out.println(result2); // 5.333333333333333

		//SET
		ohMy = Stream.of("lions", "tigers", "bears");
		TreeSet<String> result3 = ohMy.filter(s -> s.startsWith("t"))
				.collect(Collectors.toCollection(TreeSet::new));
		out.println(result3); // [tigers]

		ohMy = Stream.of("lions", "tigers", "bears");
		Set<String> result4 = ohMy.filter(s -> s.startsWith("t"))
				.collect(Collectors.toSet());
		out.println(result4); // [tigers]


		//MAPS
		ohMy = Stream.of("lions", "tigers", "bears");
		Map<String, Integer> map = ohMy.collect(Collectors.toMap(
				s -> s, String::length));
		out.println(map); // {lions=5, bears=5, tigers=6}

		ohMy = Stream.of("lions", "tigers", "bears");
		/** Map<Integer, String> map2 = ohMy.collect(Collectors.toMap(String::length, k -> k)); */// BAD //java.lang.IllegalStateException: Duplicate key lions

		Map<Integer, String> map2 = ohMy.collect(Collectors.toMap(
				String::length, k -> k, (s1, s2) -> s1 + "," + s2));
		out.println(map2); // {5=lions,bears, 6=tigers}
		out.println(map2.getClass()); // class. java.util.HashMap

		ohMy = Stream.of("lions", "tigers", "bears");
		TreeMap<Integer, String> map3 = ohMy.collect(Collectors.toMap(
				String::length, k -> k, (s1, s2) -> s1 + "," + s2, TreeMap::new));
		out.println(map3); // // {5=lions,bears, 6=tigers}
		out.println(map3.getClass()); // class. java.util.TreeMap


		// group all of the elements of the stream into lists
		// organizing them by the function provided
		ohMy = Stream.of("lions", "tigers", "bears");
		Map<Integer, List<String>> map4 = ohMy.collect(Collectors.groupingBy(String::length));
		out.println(map4); // {5=[lions, bears], 6=[tigers]}

		
		// group of set
		ohMy = Stream.of("lions", "tigers", "bears");
		Map<Integer, Set<String>> map5 = ohMy.collect(
		Collectors.groupingBy(String::length, Collectors.toSet()));
		out.println(map5); // {5=[lions, bears], 6=[tigers]}
		
		// tree group of set
		ohMy = Stream.of("lions", "tigers", "bears");
		TreeMap<Integer, Set<String>> map6= ohMy.collect(
		Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
		out.println(map6); // {5=[lions, bears], 6=[tigers]}
		
		// tree group of list
		ohMy = Stream.of("lions", "tigers", "bears");
		TreeMap<Integer, List<String>> map7 = ohMy.collect(
		Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
		out.println(map7);
		
		// Partitioning is a special case of grouping
		// two possible  groups — true and false
		ohMy = Stream.of("lions", "tigers", "bears");
		Map<Boolean, List<String>> map8 = ohMy.collect(
		Collectors.partitioningBy(s -> s.length() <= 5));
		out.println(map8); // {false=[tigers], true=[lions, bears]}
		
		// partition in sets
		ohMy = Stream.of("lions", "tigers", "bears");
		Map<Boolean, Set<String>> map9 = ohMy.collect(
		Collectors.partitioningBy(s -> s.length() <= 7, Collectors.toSet()));
		out.println(map9);// {false=[], true=[lions, tigers, bears]}
		
		//group by quantity of each value
		ohMy = Stream.of("lions", "tigers", "bears");
		Map<Integer, Long> map10 = ohMy.collect(Collectors.groupingBy(
		String::length, Collectors.counting()));
		out.println(map10); // {5=2, 6=1}
		
		// collector that lets us go down a level and add another collector
		
		ohMy = Stream.of("lions", "tigers", "bears");
		Map<Integer, Optional<Character>> map11 = ohMy.collect(
		Collectors.groupingBy(
				String::length,
				mapping(s -> s.charAt(0), minBy(Comparator.naturalOrder()))));
		out.println(map11); // {5=Optional[b], 6=Optional[t]}
	}

}
