package ocp.ch3.GenericsAndCollections.Bounds;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcards {

	public static void printList(List<Object> list) {
		for (Object x : list)
			out.println(x);
	}

	public static void printList2(List<?> list) {
		for (Object x : list)
			out.println(x);
	}

	public static void main(String[] args) {
		List<String> keywords = new ArrayList<>();
		keywords.add("java");

		// List<String> cannot be assigned to List<Object>.
		/** printList(keywords); */ // DOES NOT COMPILE

		printList2(keywords);

		Integer[] numbers = { new Integer(42) };
		Object[] objects = numbers;
		// Java knows it is really an Integer[].
		objects[0] = "forty two"; // throws ArrayStoreException

	}

}