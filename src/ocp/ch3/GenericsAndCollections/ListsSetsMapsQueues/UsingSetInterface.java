package ocp.ch3.GenericsAndCollections.ListsSetsMapsQueues;

import static java.lang.System.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

// You use a set when you don’t want to allow duplicate entries
// You aren’t concerned with the order

public class UsingSetInterface {
	public static void main(String[] args) {

		// stores its elements in a hash table
		Set<Integer> set = new HashSet<>();

		// stores its elements in a sorted tree structure. Comparable interface is used
		// for sorting
		// the set is always in sorted order.
		// adding and checking if an element is present are both O(log n).
		// implements NavigableSet,
		TreeSet<Integer> set2 = new TreeSet<>();

		boolean b1 = set.add(66); // true
		boolean b2 = set.add(10); // true
		boolean b3 = set.add(66); // false
		boolean b4 = set.add(8); // true
		for (Integer integer : set)
			out.print(integer + ","); // 66,8,10,
		out.println();

		boolean b5 = set2.add(66); // true
		boolean b6 = set2.add(10); // true
		boolean b7 = set2.add(66); // false
		boolean b8 = set2.add(8); // true
		for (Integer integer : set2)
			out.print(integer + ","); // 8,10,66
		out.println();
		out.println();

		// NavigableSet interface
		// E lower(E e) Returns greatest element that is < e, or null if no such element
		// E floor(E e) Returns greatest element that is <= e, or null if no such
		// element
		// E ceiling(E e) Returns smallest element that is >= e, or null if no such
		// element
		// E higher(E e) Returns smallest element that is > e, or null if no such
		// element

		set2 = new TreeSet<>();
		for (int i = 1; i <= 20; i++)
			set2.add(i);
		out.println(set2.lower(10)); // 9
		out.println(set2.floor(10)); // 10
		out.println(set2.ceiling(20)); // 20
		out.println(set2.higher(20)); // null
	}
}
