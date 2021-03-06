package ocp.ch4.FunctionalProgramming.WorkingWithBuiltInFunctionalInterfaces;

import static java.lang.System.*;
import java.time.LocalDate;
import java.util.function.Supplier;

/*
  	@FunctionalInterface public class Supplier<T> {
		public T get();
	}
*/

public class ImplementingSupplier {

	public static void main(String[] args) {
		
		Supplier<LocalDate> s1 = LocalDate::now;
		Supplier<LocalDate> s2 = () -> LocalDate.now();
		LocalDate d1 = s1.get();
		LocalDate d2 = s2.get();
		out.println(d1);
		out.println(d2);
		
		Supplier<StringBuilder> ss1 = StringBuilder::new;
		Supplier<StringBuilder> ss2 = () -> new StringBuilder();
		out.println(ss1.get());
		out.println(ss2.get());
	}
}
