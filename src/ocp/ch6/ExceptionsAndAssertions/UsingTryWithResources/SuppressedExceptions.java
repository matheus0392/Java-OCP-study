package ocp.ch6.ExceptionsAndAssertions.UsingTryWithResources;

import static java.lang.System.out;

public class SuppressedExceptions {

	public static void main(String[] args) {

		try (JammedTurkeyCage t = new JammedTurkeyCage()) {
			throw new IllegalStateException("turkeys ran off");
		} catch (IllegalStateException e) {
			out.println("caught: " + e.getMessage());
			for (Throwable t : e.getSuppressed())
				out.println("suppressed: " + t.getMessage());
		}
		out.println();

		try (JammedTurkeyCage t = new JammedTurkeyCage()) {
		} /*catch (Exception e) {
			out.println("caught: " + e.getMessage());
			for (Throwable t : e.getSuppressed())
				out.println("suppressed: " + t.getMessage());
		}*/
	}

}

class JammedTurkeyCage implements java.lang.AutoCloseable {
	public void close() throws IllegalStateException {
		throw new IllegalStateException("Cage door does not close");
	}

	public static void main(String[] args) {
		try (JammedTurkeyCage t = new JammedTurkeyCage()) {
			out.println("put turkeys in");
		} catch (IllegalStateException e) { // close() exception
			out.println("caught: " + e.getMessage());
		}
	}
}
