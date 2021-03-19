package ocp.ch7.Concurrency.ManagingConcurrentProcesses;

import static java.lang.System.out;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreatingCyclicBarrier {

	public static void main(String[] args) {

	}

}

class LionPenManager {
	private void removeAnimals() {
		out.println("Removing animals");
	}

	private void cleanPen() {
		out.println("Cleaning the pen");
	}

	private void addAnimals() {
		out.println("Adding animals");
	}

	public void performTask() {
		removeAnimals();
		cleanPen();
		addAnimals();
	}

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(4);
			LionPenManager manager = new LionPenManager();
			for (int i = 0; i < 4; i++)
				service.submit(() -> manager.performTask());
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}

class LionPenManager2{
	private void removeAnimals() {
		out.println("Removing animals");
	}

	private void cleanPen() {
		out.println("Cleaning the pen");
	}

	private void addAnimals() {
		out.println("Adding animals");
	}

	public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
		try {
			removeAnimals();
			c1.await();
			cleanPen();
			c2.await();
			addAnimals();
		} catch (InterruptedException | BrokenBarrierException e) {
// Handle checked exceptions here
		}
	}

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(4);
			LionPenManager2 manager = new LionPenManager2();
			CyclicBarrier c1 = new CyclicBarrier(4);
			CyclicBarrier c2 = new CyclicBarrier(4, () -> out.println("*** Pen Cleaned!"));
			for (int i = 0; i < 4; i++)
				service.submit(() -> manager.performTask(c1, c2));
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}