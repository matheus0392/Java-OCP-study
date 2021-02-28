package ocp.ch3.GenericsAndCollections.ListsSetsMapsQueues;

import static java.lang.System.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonCollectionsMethods {
	public static void main(String[] args) {

		// inserts a new element into the Collection and returns whether it was
		// successful.
		// boolean add(E element)

		List<String> list = new ArrayList<>();
		out.println(list.add("Sparrow")); // true
		out.println(list.add("Sparrow")); // true

		Set<String> set = new HashSet<>();
		out.println(set.add("Sparrow")); // true
		out.println(set.add("Sparrow")); // false
		out.println();

		// removes a single matching value in the Collection and returns whether it was
		// successful
		// boolean remove(Object object)
		// boolean remove(int index)
		List<String> birds = new ArrayList<>();
		birds.add("hawk"); // [hawk]
		birds.add("hawk"); // [hawk, hawk]
		out.println(birds.remove("cardinal")); // prints false
		out.println(birds.remove("hawk")); // prints true
		out.println(birds); // [hawk]
		out.println(birds.remove(0));
		out.println(birds); // []
		// index that doesn’t exist will throw an exception
		// birds.remove(100); // throws anIndexOutOfBoundsException
		out.println();

		// methods look at how many elements are in the Collection
		// boolean isEmpty()
		// int size()

		out.println(birds.isEmpty()); // true
		out.println(birds.size()); // 0
		birds.add("hawk"); // [hawk]
		birds.add("hawk"); // [hawk, hawk]
		out.println(birds.isEmpty()); // false
		out.println(birds.size()); // 2
		out.println();
		// method provides an easy way to discard all elements of the Collection
		// void clear()

		birds = new ArrayList<>();
		birds.add("hawk"); // [hawk]
		birds.add("hawk"); // [hawk, hawk]
		out.println(birds.isEmpty()); // false
		out.println(birds.size()); // 2
		birds.clear(); // []
		out.println(birds.isEmpty()); // true
		out.println(birds.size()); // 0
		out.println();
		// method checks if a certain value is in the Collection.
		// boolean contains(Object object)

		birds = new ArrayList<>();
		birds.add("hawk"); // [hawk]
		out.println(birds.contains("hawk")); // true
		out.println(birds.contains("robin")); // false

	}
}
