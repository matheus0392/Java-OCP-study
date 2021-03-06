package ocp.ch4.FunctionalProgramming.WorkingWithPrimitives;

import static java.lang.System.out;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class SummarizingStatistics {

	public static void main(String[] args) {

		IntStream ints = IntStream.of();
		IntSummaryStatistics stats = ints.summaryStatistics();
		if (stats.getCount() == 0)
			throw new RuntimeException();

		out.println(stats.getMax());
		out.println(stats.getMin());
		out.println(stats.getCount());
		out.println(stats.getSum());
		out.println(stats.getAverage());

	}

}
