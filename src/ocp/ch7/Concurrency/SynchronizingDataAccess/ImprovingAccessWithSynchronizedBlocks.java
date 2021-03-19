package ocp.ch7.Concurrency.SynchronizingDataAccess;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ImprovingAccessWithSynchronizedBlocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SheepManager2 manager = new SheepManager2();
		synchronized (manager) {
			// Work to be completed by one thread at a time
		}
	}

}

class SheepManager2 {
	private int sheepCount = 0;
	private AtomicInteger sheepCount2 = new AtomicInteger(0);

	private void incrementAndReport() {
		synchronized (this) {
			System.out.print((++sheepCount) + " ");
		}
	}

	public static void main(String[] args) {
		ExecutorService service = null;
		for (int x = 0; x < 1; x++) {
			try {
				service = Executors.newFixedThreadPool(20);
				SheepManager2 manager = new SheepManager2();
				for (int i = 0; i < 10; i++) {
					service.submit(() -> manager.incrementAndReport());
				}
			} finally {
				if (service != null)
					service.shutdown();
			}
		}
	}
}