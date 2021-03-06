package ocp.ch4.FunctionalProgramming.UsingVariablesInLambdas;

// Lambdas use the same access rules as inner classes
// “effectively final”
public class UsingVariablesInLambdas {
	public static void main(String[] args) {
	}
}

interface Gorilla {
	String move();
}

class GorillaFamily {
	String walk = "walk"; // can use instance variable in lambda

	static String talk = "talk"; // can use static variable in lambda

	void everyonePlay(boolean baby) {

		// it is effectively final since there are no reassignments to that variable.
		play(() -> baby ? "hitch a ride" : "run");
		/** baby = true; // no more effectively final*/

		String approach = "amble";
		approach = "run";
		/** play(() -> approach); */ // DOES NOT COMPILE

		this.walk = "qwd";
		play(() -> walk);

		GorillaFamily.talk = "qasc";
		play(() -> talk);
	}

	void play(Gorilla g) {
		System.out.println(g.move());
	}
}