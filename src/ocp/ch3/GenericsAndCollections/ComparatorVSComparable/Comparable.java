package ocp.ch3.GenericsAndCollections.ComparatorVSComparable;

import java.util.*;

//The Comparable interface has only one method.
// public int compareTo(T o);

public class Comparable {

}

class Duck implements java.lang.Comparable<Duck> {
	private String name;

	public Duck(String name) {
		this.name = name;

	}

	public String toString() { // use readable output
		return name;
	}

	@Override
	public int compareTo(Duck d) {
		return name.compareTo(d.name); // call String's compareTo
	}

	public static void main(String[] args) {
		List<Duck> ducks = new ArrayList<>();
		ducks.add(new Duck("Quack"));
		ducks.add(new Duck("Puddles"));
		Collections.sort(ducks); // sort by name
		System.out.println(ducks); // [Puddles, Quack]
	}

}

class Animal implements java.lang.Comparable<Animal> {
	private int id;

	public int compareTo(Animal a) {
		return id - a.id;
	}

	public static void main(String[] args) {
		Animal a1 = new Animal();
		Animal a2 = new Animal();

		a1.id = 5;
		a2.id = 7;
		System.out.println(a1.compareTo(a2)); // -2
		System.out.println(a1.compareTo(a1)); // 0
		System.out.println(a2.compareTo(a1)); // 2
	}
}
