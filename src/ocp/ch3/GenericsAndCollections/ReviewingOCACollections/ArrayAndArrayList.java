package ocp.ch3.GenericsAndCollections.ReviewingOCACollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAndArrayList {
	static public void main(String... args) {

		// An ArrayList cannot contain primitives
		List<String> list = new ArrayList<>(); // empty list
		list.add("Fluffy"); // [Fluffy]
		list.add("Webby"); // [Fluffy, Webby]
		String[] array = new String[list.size()]; // empty array

		array[0] = list.get(1); // [Webby]
		array[1] = list.get(0); // [Webby, Fluffy]
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + "-");
		
		System.out.println();
		System.out.println();
		// add(Object)
		// get(index)
		// size()

		String[] array2 = { "gerbil", "mouse" }; // [gerbil, mouse]

		// returns fixed size list
		// but honoring all of the other methods in the interface
		List<String> list2 = Arrays.asList(array2);
		
		for (int i = 0; i < array2.length; i++)
			System.out.print(array2[i] + " ");
		System.out.println( list2.toString());
		
		list2.set(1, "test"); // [gerbil, test]
		
		for (int i = 0; i < array2.length; i++)
			System.out.print(array2[i] + " ");
		System.out.println( list2.toString());
		
		array2[0] = "new"; // [new, test]
		
		for (int i = 0; i < array2.length; i++)
			System.out.print(array2[i] + " ");
		System.out.println( list2.toString());
		
		@SuppressWarnings("unused")
		String[] array3 = (String[]) list2.toArray(); // [new, test]
		list2.remove(1); // throws UnsupportedOperationException
	}
}
