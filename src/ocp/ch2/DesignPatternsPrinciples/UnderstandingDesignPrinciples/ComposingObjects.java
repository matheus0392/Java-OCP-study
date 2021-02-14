package ocp.ch2.DesignPatternsPrinciples.UnderstandingDesignPrinciples;

import static java.lang.System.*;

public class ComposingObjects {

}

class Flippers {
	public void flap() {
		out.println("The flippers flap back and forth");
	}
}

class WebbedFeet {
	public void kick() {
		out.println("The webbed feet kick to and fro");
	}
}

class Penguin {
	//WebbedFeet are not the same as Flippers
	private final Flippers flippers;
	private final WebbedFeet webbedFeet;

	public Penguin() {
		this.flippers = new Flippers();
		this.webbedFeet = new WebbedFeet();
	}

	//delegate method
	public void flap() {
		this.flippers.flap();
	}

	public void kick() {
		this.webbedFeet.kick();
	}
}