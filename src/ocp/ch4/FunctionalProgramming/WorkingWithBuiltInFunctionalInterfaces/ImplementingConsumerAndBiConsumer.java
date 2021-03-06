package ocp.ch4.FunctionalProgramming.WorkingWithBuiltInFunctionalInterfaces;

import static java.lang.System.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/*
	@FunctionalInterface public class Consumer<T> {
		void accept(T t);
	}
	
	@FunctionalInterface public class BiConsumer<T, U> {
		void accept(T t, U u);
	}
*/

public class ImplementingConsumerAndBiConsumer {

	public static void main(String[] args) {

		Consumer<String> c1 = out::println;
		Consumer<String> c2 = x -> out.println(x);
		c1.accept("Annie");
		c2.accept("Annie");
		
		Map<String, Integer> map = new HashMap<>();
		BiConsumer<String, Integer> b1 = map::put;
		BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
		b1.accept("chicken", 7);
		b2.accept("chick", 1);
		out.println(map);
		
		Map<String, String> map2 = new HashMap<>();
		BiConsumer<String, String> bb1 = map2::put;
		BiConsumer<String, String> bb2 = (k, v) -> map2.put(k, v);
		bb1.accept("chicken", "Cluck");
		bb2.accept("chick", "Tweep");
		out.println(map2);
	}

}
