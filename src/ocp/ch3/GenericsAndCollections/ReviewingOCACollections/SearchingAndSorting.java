package ocp.ch3.GenericsAndCollections.ReviewingOCACollections;

import static java.lang.System.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchingAndSorting {

	public static void main(String... args) {
		int[] numbers = { 6, 9, 1, 8 };
		Arrays.sort(numbers); // [1,6,8,9]
		for (int i = 0; i < numbers.length; i++)
			out.print(numbers[i] + " ");
		out.println();
		out.println(Arrays.binarySearch(numbers, 6)); // 1
		out.println(Arrays.binarySearch(numbers, 3)); // -2

		List<Integer> list = Arrays.asList(9, 7, 5, 3);
		Collections.sort(list); // [3, 5, 7, 9]
		out.println(list);
		out.println(Collections.binarySearch(list, 3)); // 0
		out.println(Collections.binarySearch(list, 2)); // -1
	}

}