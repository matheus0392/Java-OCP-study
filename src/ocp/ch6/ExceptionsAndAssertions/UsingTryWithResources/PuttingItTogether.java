package ocp.ch6.ExceptionsAndAssertions.UsingTryWithResources;

import static java.lang.System.out;

public class PuttingItTogether {

	public static void main(String[] args) {
		try (Auto a1 = new Auto(1); Auto a2 = new Auto(2)) {
			throw new RuntimeException();
		} catch (Exception e) {
			out.println("ex");
		} finally {
			out.println("finally");
		}
	}
}

class Auto implements java.lang.AutoCloseable {
	int num;

	Auto(int num) {
		this.num = num;
	}

	public void close() {
		out.println("Close: " + num);
	}

}