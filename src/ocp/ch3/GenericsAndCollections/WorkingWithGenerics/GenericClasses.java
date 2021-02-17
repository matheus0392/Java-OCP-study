package ocp.ch3.GenericsAndCollections.WorkingWithGenerics;

public class GenericClasses {

	static public void main(String... args) {

		Elephant elephant = new Elephant();
		Crate<Elephant> crateForElephant = new Crate<>();
		crateForElephant.packCrate(elephant);
		Elephant inNewHome = crateForElephant.emptyCrate();

		Crate<Zebra> crateForZebra = new Crate<>();

		Robot joeBot = new Robot();
		Crate<Robot> robotCrate = new Crate<>();
		robotCrate.packCrate(joeBot);
		// ship to St. Louis
		Robot atDestination = robotCrate.emptyCrate();

		elephant = new Elephant();
		Integer numPounds = 15_000;
		SizeLimitedCrate<Elephant, Integer> c1 = new SizeLimitedCrate<>(elephant, numPounds);
	}
}

class Elephant {
}

class Zebra {
}

class Robot {
}

//Generic classes become useful when the classes used as the type parameter can have absolutely
//nothing to do with each other.
class Crate<T> {
	private T contents;

	public T emptyCrate() {
		return contents;
	}

	public void packCrate(T contents) {
		this.contents = contents;
	}
}

//Generic classes aren’t limited to having a single type parameter
class SizeLimitedCrate<T, U> {
	private T contents;
	private U sizeLimit;

	public SizeLimitedCrate(T contents, U sizeLimit) {
		this.contents = contents;
		this.sizeLimit = sizeLimit;
	}
}