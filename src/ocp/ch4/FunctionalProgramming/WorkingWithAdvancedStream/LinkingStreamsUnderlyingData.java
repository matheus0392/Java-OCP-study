package ocp.ch4.FunctionalProgramming.WorkingWithAdvancedStream;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LinkingStreamsUnderlyingData {
	public static void main(String[] args) {

		List<String> cats = new ArrayList<>();
		cats.add("Annie");
		cats.add("Ripley");
		Stream<String> stream = cats.stream();
		cats.add("KC");
		out.println(stream.count());
	}
}