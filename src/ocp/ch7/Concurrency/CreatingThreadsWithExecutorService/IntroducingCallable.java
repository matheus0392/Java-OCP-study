package ocp.ch7.Concurrency.CreatingThreadsWithExecutorService;

import static java.lang.System.out;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

public class IntroducingCallable {

	public static void main(String[] args) {	}

}

class AmbiguousLambdaSample {
	public static void useCallable(Callable<Integer> expression) {
	}

	public static void useSupplier(Supplier<Integer> expression) {
	}

	public static void use(Supplier<Integer> expression) {
	}

	public static void use(Callable<Integer> expression) {
	}

	public static void main(String[] args) {
		useCallable(() -> {
			throw new IOException();
		}); // COMPILES
		/** useSupplier(() -> { throw new IOException(); }); */ // DOES NOT COMPILE
		/** use(() -> { throw new IOException(); }); */ // DOES NOT COMPILE
		use((Callable<Integer>) () -> {
			throw new IOException("");
		}); // COMPILES
	}
}

class AddData {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<Integer> result = service.submit(() -> 30 + 11);
			out.println(result.get());
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}