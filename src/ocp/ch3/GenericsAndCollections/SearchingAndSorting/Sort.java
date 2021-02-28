package ocp.ch3.GenericsAndCollections.SearchingAndSorting;

import java.util.*;

public class Sort {

	// Java knows that the Rabbit class is not Comparable
	static class Rabbit {
		int id;
	}

	public static void main(String[] args) {
		List<Rabbit> rabbits = new ArrayList<>();
		rabbits.add(new Rabbit());
		//
		/** Collections.sort(rabbits); */ // DOES NOT COMPILE

		// sort() and binarySearch() allow you to pass in a Comparator object
		Comparator<Rabbit> c = (r1, r2) -> r1.id - r2.id;
		Collections.sort(rabbits, c);

		List<String> names = Arrays.asList("Fluffy", "Hoppy");
		Comparator<String> c2 = Comparator.reverseOrder();
		int index = Collections.binarySearch(names, "Hoppy", c2);
		System.out.println(index);
	}
}

class UseTreeSet {
	static class Rabbit {
		int id;
	}

	public static void main(String[] args) {
		// not implements comparable
		Set<Rabbit> rabbit = new TreeSet<>();
		/*** rabbit.add(new Rabbit()); */ // throws an exception

		Set<Rabbit> rabbitSet = new TreeSet<>(new Comparator<Rabbit>() {
			public int compare(Rabbit r1, Rabbit r2) {
				return r1.id = r2.id;
			}
		});
		rabbitSet.add(new Rabbit());
	}
}
