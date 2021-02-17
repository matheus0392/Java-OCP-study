package ocp.ch3.GenericsAndCollections.WorkingWithGenerics;

public class GenericMethods {

	// Before the return type, we declare the formal type parameter of <T>.
	public static <T> Crate<T> ship(T t) {
		System.out.println("Preparing " + t);
		return new Crate<T>();
	}

	public static <T> void sink(T t) {
	}

	public static <T> T identity(T t) {
		return t;
	}

	/**
	 * public static T noGood(T t) { return t; }
	 */ // DOES NOT COMPILE

	static public void main(String... args) {
		GenericMethods.ship("package");
		GenericMethods.ship(args);
		GenericMethods.<String>ship("package"); //optional explicit type
		GenericMethods.<String[]>ship(args);
	}
}
