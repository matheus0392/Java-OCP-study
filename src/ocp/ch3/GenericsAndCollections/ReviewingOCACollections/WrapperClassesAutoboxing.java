package ocp.ch3.GenericsAndCollections.ReviewingOCACollections;

import java.util.ArrayList;
import java.util.List;
import static java.lang.System.*;

public class WrapperClassesAutoboxing {

	static public void main(String... args) {
		// Autoboxing automatically converts a primitive to the corresponding wrapper classes
		// Unboxing automatically converts a wrapper class back to a primitive
		new Boolean(true);
		new Byte((byte) 1);
		new Short((short) 1);
		new Integer(1);
		new Long(1);
		new Float(1.0);
		new Double(1.0);
		new Character('c');


		List<Integer> numbers = new ArrayList<Integer>();
		// Autoboxing
		numbers.add(1);
		numbers.add(new Integer(3));
		numbers.add(new Integer(5));
		numbers.remove(1);
		numbers.remove(new Integer(5));
		out.println(numbers);
		
		// Unboxing
		int num = numbers.get(0);
	}
}
