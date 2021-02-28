package ocp.ch3.GenericsAndCollections.ListsSetsMapsQueues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// You use a list when you want an ordered collection that can contain duplicate entries
// Items can be retrieved and inserted at specific positions in the list based on an int index

public class UsingListInterface {
	public static void main(String[] args) {

		// good choice when you’ll be using it as Queue
		ArrayDeque<String> array = new ArrayDeque<>();

		// If you need a stack
		LinkedList<String> array2 = new LinkedList<>();

		// void add(E element) Adds element to end
		// void add(int index, E element) Adds element at index and moves the rest
		// toward the end
		// E get(int index) Returns element at index
		// int indexOf(Object o) Returns first matching index or -1 if not found
		// int lastIndexOf(Object o) Returns last matching index or -1 if not found
		// void remove(int index) Removes element at index and moves the rest toward the
		// front
		// E set(int index, E e) Replaces element at index and returns original

		List<String> list = new ArrayList<>();
		list.add("SD"); // [SD]
		list.add(0, "NY"); // [NY,SD]
		list.set(1, "FL"); // [NY,FL]
		list.remove("NY"); // [FL]
		list.remove(0); // []

		list.add("OH"); // [OH]
		list.add("CO"); // [OH,CO]
		list.add("NJ"); // [OH,CO,NJ]
		String state = list.get(0); // OH
		int index = list.indexOf("NJ"); // 2
	}
}
