package ocp.ch7.Concurrency.IdentifyingThreadingProblems;

import static java.lang.System.out;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//This example is considered a deadlock because both participants are permanently
//blocked, waiting on resources that will never become available.

public class Deadlock {

	public static void main(String[] args) {
		// Create participants and resources
				Fox foxy = new Fox();
				Fox tails = new Fox();
				Food food = new Food();
				Water water = new Water();
		// Process data
				ExecutorService service = null;
				try {
					service = Executors.newScheduledThreadPool(10);
					service.submit(() -> foxy.eatAndDrink(food, water));
					service.submit(() -> tails.drinkAndEat(food, water));
				} finally {
					if (service != null)
						service.shutdown();
				}
	}

}

class Food {
}

class Water {
}

class Fox {
	public void eatAndDrink(Food food, Water water) {
		synchronized (food) {
			out.println("Got Food!");
			move();
			synchronized (water) {
				out.println("Got Water!");
			}
		}
	}

	public void drinkAndEat(Food food, Water water) {
		synchronized (water) {
			out.println("Got Water!");
			move();
			synchronized (food) {

				out.println("Got Food!");
			}
		}
	}

	public void move() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// Handle exception
		}
	}

}