package ocp.ch7.Concurrency.WorkingWithParallelStreams;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProcessingTasksParallel {

	public static void main(String[] args) {
		Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().forEach(s -> out.print(s + " "));
		out.println();
		Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().forEachOrdered(s -> out.print(s + " "));
		out.println();

		// Understanding Independent Operations
		// mapping can be done independently
		Arrays.asList("jackal", "kangaroo", "lemur").parallelStream().map(s -> s.toUpperCase()).forEach(out::println);
		out.println();

		Arrays.asList("jackal", "kangaroo", "lemur").parallelStream().map(s -> {
			out.println(s);
			return s.toUpperCase();
		}).forEach(out::println);
		out.println();
		
		// Avoiding Stateful Operations
		List<Integer> data = Collections.synchronizedList(new ArrayList<>());
		Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().map(i -> {
			data.add(i);
			return i;
		}) // AVOID STATEFUL LAMBDA EXPRESSIONS!
			.forEachOrdered(i -> out.print(i + " "));
		out.println();
		for (Integer e : data) {
			out.print(e + " ");
		}

	}

}

class WhaleDataCalculator {
	public int processRecord(int input) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
// Handle interrupted exception
		}
		return input + 1;
	}

	public void processAllData(List<Integer> data) {
		data.stream().map(a -> processRecord(a)).count();
	}

	public void processAllData2(List<Integer> data) {
		data.parallelStream().map(a -> processRecord(a)).count();
	}

	public static void main(String[] args) {
		// Understanding Performance Improvements
		WhaleDataCalculator calculator = new WhaleDataCalculator();
		// Define the data
		List<Integer> data = new ArrayList<Integer>();
		for (int i = 0; i < 400; i++)
			data.add(i);
		// Process the data
		long start = System.currentTimeMillis();
		calculator.processAllData(data);
		double time = (System.currentTimeMillis() - start) / 1000.0;
		// Report results
		out.println("\nTasks completed in: " + time + " seconds");

		// Process the data
		start = System.currentTimeMillis();
		calculator.processAllData2(data);
		time = (System.currentTimeMillis() - start) / 1000.0;
		// Report results
		out.println("\nTasks completed in: " + time + " seconds");

	}
}
