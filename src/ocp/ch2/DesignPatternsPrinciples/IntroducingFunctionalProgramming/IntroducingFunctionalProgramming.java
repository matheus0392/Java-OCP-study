package ocp.ch2.DesignPatternsPrinciples.IntroducingFunctionalProgramming;

public class IntroducingFunctionalProgramming {

}

//Java defines a functional interface as an interface that contains a single abstract method
@FunctionalInterface // verify whether the class is functional or it does not compile
interface Sprint {
	public void sprint(Animal animal);
}

class Tiger implements Sprint {
	public void sprint(Animal animal) {
		System.out.println("Animal is sprinting fast! " + animal.toString());
	}
}

//valid functional interfaces
interface Run extends Sprint {
}

interface SprintFaster extends Sprint {
	public void sprint(Animal animal);
}

interface Skip extends Sprint {
	public default int getHopCount() {
		return 10;
	}

	public static void skip(int speed) {
	}
}

//not valid functional interfaces
interface Walk {
}

interface Dance extends Sprint {
	public void dance(Animal animal);
}

interface Crawl {
	public void crawl();

	public int getCount();
}