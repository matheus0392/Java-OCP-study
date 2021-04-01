package ocp.ch8.IO.WorkingWithStreams;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintStreamPrintWriter {

	public static void main(String[] args) throws IOException {
		// write()
		// print()
		// println()
		// format() printf()
		// checkError() detect the presence of a problem after attempting to write data
		// to the stream

		PrintWriter out = new PrintWriter("src\\ocp\\ch8\\IO\\WorkingWithStreams\\PrintStreamPrintWriter.log");
		out.print(5); // PrintWriter method
		out.write(String.valueOf(5)); // Writer method
		out.print(2.0); // PrintWriter method
		out.write(String.valueOf(2.0)); // Writer method
		Animal animal = new Animal();
		out.print(animal); // PrintWriter method
		out.write(animal == null ? "null" : animal.toString()); // Writer method
		out.println(out.checkError());

		PrintStream out2 = new PrintStream("src\\ocp\\ch8\\IO\\WorkingWithStreams\\PrintStreamPrintWriter2.log");
		out2.print(5); // PrintWriter method
		out2.write(String.valueOf(5).getBytes()); // Writer method
		out2.print(2.0); // PrintWriter method
		out2.write(String.valueOf(2.0).getBytes()); // Writer method
		out2.print(animal); // PrintWriter method
		out2.write(animal == null ? "null".getBytes() : animal.toString().getBytes()); // Writer method
		out.println(out2.checkError());

	}

}

class PrintWriterSample {
	public static void main(String[] args) {
		File source = new File("src\\ocp\\ch8\\IO\\WorkingWithStreams\\PrintStreamPrintWriter3.log");
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(source)))) {
			out.print("Today's weather is: ");
			out.println("Sunny");
			out.print("Today's temperature at the zoo is: ");
			out.print(1 / 3.0);
			out.println('C');
			out.format("It has rained 10.12 inches this year");
			out.println();
			out.printf("It may rain 21.2 more inches this year");
			out.append('2');
		}catch(IOException e) {
			
		}
	}
}