package ocp.ch4.FunctionalProgramming.WorkingWithBuiltInFunctionalInterfaces;

import static java.lang.System.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/*
	@FunctionalInterface public class Function<T, R> {
		R apply(T t);
	}
	
	@FunctionalInterface public class BiFunction<T, U, R> {
		R apply(T t, U u);
	}
*/
public class ImplementingFunctionAndBiFunction {

	public static void main(String[] args) {

		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = x -> System.out.println(x);
		c1.accept("Annie");
		c2.accept("Annie");

		Map<String, Integer> map = new HashMap<>();
		BiConsumer<String, Integer> b1 = map::put;
		BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
		b1.accept("chicken", 7);
		b2.accept("chick", 1);
		System.out.println(map);

		Map<String, String> map2 = new HashMap<>();
		BiConsumer<String, String> bb1 = map2::put;
		BiConsumer<String, String> bb2 = (k, v) -> map2.put(k, v);
		bb1.accept("chicken", "Cluck");
		bb2.accept("chick", "Tweep");
		System.out.println(map2);
	}

}
