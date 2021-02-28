package ocp.ch3.GenericsAndCollections.AdditionsJava8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

//Method references are a way to make the code shorter by reducing some of the code
public class UsingMethodReferences {

	static public void main(String... args) {

		methodRef1.accept(new ArrayList<Integer>());

		ArrayList x = methodRef4.get();
	}

	// The :: operator tells Java to pass the parameters automatically into compareByWeight
	Comparator<Duck> byWeight = (d1, d2) -> DuckHelper.compareByWeight(d1, d2);
	Comparator<Duck> byWeight2 = DuckHelper::compareByWeight;

	// Java knows that it should create a lambda with one parameter and pass it to the method.
	static Consumer<List<Integer>> methodRef1 = Collections::sort;
	Consumer<List<Integer>> lambda1 = l -> Collections.sort(l);

	String str = "abc";
	Predicate<String> methodRef2 = str::startsWith;
	Predicate<String> lambda2 = s -> str.startsWith(s);

	// It looks like a static method, but it isn’t. Java uses the parameter supplied at runtime
	Predicate<String> methodRef3 = String::isEmpty;
	Predicate<String> lambda3 = s -> s.isEmpty();

	// A constructor reference is a special type of method reference that uses new instead of a method
	static Supplier<ArrayList> methodRef4 = ArrayList::new;
	Supplier<ArrayList> lambda4 = () -> new ArrayList();

}

class Duck {
	private String name;
	private int weight;

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public String toString() {
		return name;
	}
}

class DuckHelper {
	public static int compareByWeight(Duck d1, Duck d2) {
		return d1.getWeight() - d2.getWeight();
	}

	public static int compareByName(Duck d1, Duck d2) {
		return d1.getName().compareTo(d2.getName());
	}
}