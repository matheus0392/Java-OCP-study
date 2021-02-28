package ocp.ch3.GenericsAndCollections.ComparatorVSComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comparator {

	public static void main(String[] args) {

		java.util.Comparator<Duck2> byWeight = new java.util.Comparator<Duck2>() {
			public int compare(Duck2 d1, Duck2 d2) {
				return d1.getWeight() - d2.getWeight();
			}
		};

		java.util.Comparator<Duck2> byWeight1 = (d1, d2) -> d1.getWeight() - d2.getWeight();
		java.util.Comparator<Duck2> byWeight2 = (Duck2 d1, Duck2 d2) -> d1.getWeight() - d2.getWeight();
		java.util.Comparator<Duck2> byWeight3 = (d1, d2) -> { return d1.getWeight() - d2.getWeight();};
		java.util.Comparator<Duck2> byWeight4 = (Duck2 d1, Duck2 d2) -> {return d1.getWeight() - d2.getWeight();};

		List<Duck2> ducks = new ArrayList<>();
		ducks.add(new Duck2("Quack", 7));
		ducks.add(new Duck2("Puddles", 10));

		Collections.sort(ducks);
		System.out.println(ducks); // [Puddles, Quack]
		Collections.sort(ducks, byWeight);
		System.out.println(ducks); // [Quack, Puddles]
	}

}

class Duck2 implements java.lang.Comparable<Duck2> {
	private String name;
	private int weight;

	public Duck2(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public String toString() {
		return name;
	}

	public int compareTo(Duck2 d) {
		return name.compareTo(d.name);
	}
}