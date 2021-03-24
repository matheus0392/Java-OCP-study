package ocp.ch6.ExceptionsAndAssertions.UsingTryWithResources;

import static java.lang.System.out;

public class AutoCloseable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Turkey implements java.lang.AutoCloseable {
	@Override
	public void close() throws Exception {
		out.println("Close gate");
		throw new Exception("Cage door does not close");
	}

	public static void main(String[] args) throws Exception {
		try (Turkey t = new Turkey()) {
			out.println(t);
		}
	}
}

class ExampleOne implements java.lang.AutoCloseable {
	public void close() throws IllegalStateException {
		throw new IllegalStateException("Cage door does not close"); // OK
	}
}

class ExampleTwo implements java.lang.AutoCloseable {
	public void close() throws Exception {
		throw new Exception("Cage door does not close"); // not recommended
	}
}

class ExampleThree implements java.lang.AutoCloseable {
	static int COUNT = 0;

	public void close() {
		COUNT++; // not recommended
	}
}