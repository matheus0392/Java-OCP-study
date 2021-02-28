package ocp.ch3.GenericsAndCollections.AdditionsJava8;

import static java.lang.System.*;
import java.util.Arrays;
import java.util.List;

public class LoopingThroughCollection {

	public static void main(String[] args) {

		List<String> cats = Arrays.asList("Annie", "Ripley");
		for (String cat : cats)
			out.println(cat);

		// we learn a shorter way to loop through a Collection
		cats.forEach(c -> out.println(c));

		cats.forEach(out::println);

	}
}
