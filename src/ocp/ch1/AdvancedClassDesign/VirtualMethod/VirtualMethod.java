package ocp.ch1.AdvancedClassDesign.VirtualMethod;

import static java.lang.System.*;

abstract class Animal {
	public abstract void feed();

	String name = "???";

	public void printName() {
		out.println(name);
	}

	public void careFor() {
		play();
	}

	public void play() {
		System.out.println("pet animal");
	}
}

class Cow extends Animal {
	public void feed() {
		addHay();
	}

	private void addHay() {
		out.println("Cow addHay");
	}
}

class Bird extends Animal {
	public void feed() {
		addSeed();
	}

	private void addSeed() {
		out.println("Bird addSeed");
	}
}

class Lion extends Animal {
	String name = "Leo";

	public void feed() {
		addMeat();
	}

	private void addMeat() {
		out.println("Lion addMeat");
	}

	public void play() {
		System.out.println("toss in meat");
	}
}

public class VirtualMethod {
	public static void main(String[] args) {
		VirtualMethod vm = new VirtualMethod();

		Lion lion = new Lion();
		Cow cow = new Cow();
		Bird bird = new Bird();

		vm.feedAnimal(lion);
		vm.feedAnimal(cow);
		vm.feedAnimal(bird);

		Animal animal = new Lion();
		animal.printName();
		// The name declared in Lion would only be used if name was referred to from
		// Lion (or a subclass of Lion.)

		animal.careFor();
		// Even though the call is from the Animal class, Java still looks at subclasses
	}

	public void feedAnimal(Animal animal) {
		animal.feed();
		// Java looked at the actual type of animal at runtime and called feed on that.
	}
}
