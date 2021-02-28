package ocp.ch3.GenericsAndCollections.Bounds;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundedWildcards {

	public static long total(List<? extends Number> list) {
		long count = 0;
		for (Number number : list)
			count += number.longValue();
		return count;
	}

	public static void main(String[] args) {
		/** ArrayList<Number> list = new ArrayList<Integer>(); */ // DOES NOT COMPILE Integer extends Number

		// any class that extends Number or Number itself can be used
		List<? extends Number> list = new ArrayList<Integer>();

		List<? extends Bird> birds = new ArrayList<Bird>();

		// both scenarios are equally possible so neither is allowed
		/** birds.add(new Sparrow()); */ // DOES NOT COMPILE
		/** birds.add(new Bird()); */ // DOES NOT COMPILE

	}

	static class Sparrow extends Bird {
	}

	static class Bird {
	}

}

class UpperBoundedWildcards2 {
	public static void main(String[] args) {

		ArrayList<Flyer> listFlyer = new ArrayList<Flyer>();
		listFlyer.add(new HangGlider());
		listFlyer.add(new Goose());

		ArrayList<HangGlider> listHangGlider = new ArrayList<HangGlider>();
		listHangGlider.add(new HangGlider());

		ArrayList<Goose> listGoose = new ArrayList<Goose>();
		listGoose.add(new Goose());

		new UpperBoundedWildcards2().anyFlyer(listFlyer);
		/** new UpperBoundedWildcards2().anyFlyer(listHangGlider); */ // DOES NOT COMPILE
		/** new UpperBoundedWildcards2().anyFlyer(listGoose); */ // DOES NOT COMPILE

		out.println();

		new UpperBoundedWildcards2().groupOfFlyers(listFlyer);
		new UpperBoundedWildcards2().groupOfFlyers(listHangGlider);
		new UpperBoundedWildcards2().groupOfFlyers(listGoose);

	}

	private void anyFlyer(List<Flyer> flyers) {

		// List<Flyer> HangGlider or Goose
		for (Flyer flyer : flyers) {
			flyer.fly();
		}

	}

	private void groupOfFlyers(List<? extends Flyer> flyers) {

		// List<Flyer> HangGlider or Goose
		// List<HangGlider> HangGlider
		// List<Goose> Goose
		for (Flyer flyer : flyers) {
			flyer.fly();
		}
	}
}

interface Flyer {
	void fly();
}

class HangGlider implements Flyer {
	public void fly() {
		out.println("HangGlider flying");
	}
}

class Goose implements Flyer {
	public void fly() {
		out.println("Goose flying");
	}
}
