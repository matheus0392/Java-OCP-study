package ocp.ch1.AdvancedClassDesign.OverriddingLangObject;

import static java.lang.System.*;

import java.util.ArrayList;

public class OverriddingLangObject {
	public static void main(String[] args) {

		out.println(new ArrayList()); // []
		out.println(new String[0]); // [Ljava.lang.String;@65cc892e

		String s1 = new String("lion");
		String s2 = new String("lion");
		System.out.println(s1.equals(s2)); // true
		StringBuilder sb1 = new StringBuilder("lion");
		StringBuilder sb2 = new StringBuilder("lion");
		System.out.println(sb1.equals(sb2)); // false
	}
}

class Hippo {
	private String name;
	private double weight;

	public Hippo(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}

	public String toString() {
		return "Name: " + name + ", Weight: " + weight;
	}
	//public String toString()

	public static void main(String[] args) {
		Hippo h1 = new Hippo("Harry", 3100);
		System.out.println(h1); // Harry
	}
}

class Lion {
	private int idNumber;
	private int age;
	private String name;

	public Lion(int idNumber, int age, String name) {
		this.idNumber = idNumber;
		this.age = age;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Lion))
			return false;
		Lion otherLion = (Lion) obj;
		return this.idNumber == otherLion.idNumber;
	}
	//public boolean equals(Object obj)

	public int hashCode() { return idNumber; }
}
