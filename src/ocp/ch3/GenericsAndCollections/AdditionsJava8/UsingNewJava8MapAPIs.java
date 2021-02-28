package ocp.ch3.GenericsAndCollections.AdditionsJava8;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class UsingNewJava8MapAPIs {

	public static void main(String[] args) {

		Map<String, String> favorites = new HashMap<>();
		favorites.put("Jenny", "Bus Tour");
		favorites.put("Tom", null);

		// this method skips it if the value is already set to a non-null value
		favorites.putIfAbsent("Jenny", "Tram");
		favorites.putIfAbsent("Sam", "Tram");
		favorites.putIfAbsent("Tom", "Tram");
		out.println(favorites); // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}
		out.println();

		BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
		favorites = new HashMap<>();
		favorites.put("Jenny", "Bus Tour");
		favorites.put("Tom", "Tram");

		// adding logic to the problem of what to choose
		// The key is removed from the map if it returns null.
		String jenny = favorites.merge("Jenny", "Skyride", mapper);
		String tom = favorites.merge("Tom", "Skyride", mapper);
		out.println(favorites); // {Tom=Skyride, Jenny=Bus Tour}
		out.println(jenny); // Bus Tour
		out.println(tom); // Skyride
		out.println();

		Map<String, Integer> counts = new HashMap<>();
		counts.put("Jenny", 1);
		BiFunction<String, Integer, Integer> mapper2 = (k, v) -> v + 1;
		Integer jenny2 = counts.computeIfPresent("Jenny", mapper2);
		Integer sam = counts.computeIfPresent("Sam", mapper2);
		out.println(counts); // {Jenny=2}
		out.println(jenny2); // 2
		out.println(sam); // null
		out.println();

		counts = new HashMap<>();
		counts.put("Jenny", 15);
		counts.put("Tom", null);
		Function<String, Integer> mapper3 = (k) -> 1;
		jenny2 = counts.computeIfAbsent("Jenny", mapper3); // 15
		sam = counts.computeIfAbsent("Sam", mapper3); // 1
		Integer tom2 = counts.computeIfAbsent("Tom", mapper3); // 1
		out.println(counts); // {Tom=1, Jenny=15, Sam=1}
		out.println(jenny2); // 2
		out.println(sam); // null
		out.println(tom2); // 2
		out.println();

		// If the mapping function is called and returns null,
		// for computeIfAbsent(), the key is never added to the map
		counts = new HashMap<>();
		counts.put("Jenny", 1);
		counts.computeIfPresent("Jenny", (k, v) -> null);
		counts.computeIfAbsent("Sam", k -> null);
		out.println(counts); // {}

	}

}
