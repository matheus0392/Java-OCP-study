package ocp.ch3.GenericsAndCollections.AdditionsJava8;

import static java.lang.System.*;
import java.util.ArrayList;
import java.util.List;

public class RemovingConditionally {

	// we can specify what should be deleted using a block of code
	// boolean removeIf(Predicate<? super E> filter)

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("Magician");
		list.add("Assistant");
		out.println(list); // [Magician, Assistant]
		list.removeIf(s -> s.startsWith("A"));
		out.println(list); // [Magician]

	}

}
