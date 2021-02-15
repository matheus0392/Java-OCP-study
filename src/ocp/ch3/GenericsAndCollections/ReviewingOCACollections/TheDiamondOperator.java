package ocp.ch3.GenericsAndCollections.ReviewingOCACollections;

import static java.lang.System.*;
import java.util.*;

public class TheDiamondOperator {
	static public void main(String... args) {

	}

	List<String> names;

	TheDiamondOperator() {
		names = new ArrayList<>(); // matches instance variable declaration
	}

	public void copyNames() {
		ArrayList<String> copyOfNames;
		copyOfNames = new ArrayList<>(); // matches local variable declaration
	}

}
