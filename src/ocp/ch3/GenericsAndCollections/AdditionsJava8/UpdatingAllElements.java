package ocp.ch3.GenericsAndCollections.AdditionsJava8;

import static java.lang.System.*;
import java.util.Arrays;
import java.util.List;

public class UpdatingAllElements {
	// pass a expression and have it applied to each element in the list

	// void replaceAll(UnaryOperator<E> o)

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3);
		list.replaceAll(x -> x * 2);
		out.println(list); // [2, 4, 6]
	}

}
