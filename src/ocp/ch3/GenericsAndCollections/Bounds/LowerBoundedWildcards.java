package ocp.ch3.GenericsAndCollections.Bounds;

import static java.lang.System.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LowerBoundedWildcards {

	// list of String objects or a list of some objects that are a superclass of String
	public static void addSound(List<? super String> list) { // lower bound
		list.add("quack");
	}

	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		strings.add("tweet");
		List<Object> objects = new ArrayList<Object>(strings);
		addSound(strings);
		addSound(objects);

		List<? super IOException> exceptions = new ArrayList<Exception>();

		// we could have a List<IOException>
		/** exceptions.add(new Exception()); */ // DOES NOT COMPILE
		exceptions.add(new IOException());
		exceptions.add(new FileNotFoundException());

		for (Object exception : exceptions) {
			out.println(exception.toString());
		}
	}

}
