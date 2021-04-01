package ocp.ch8.IO.WorkingWithStreams;

import static java.lang.System.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReaderFileWriter {

	public static void main(String[] args) {
		// close() and flush(),
		// write(String)
		// readLine()
	}

}


class CopyTextFileSample {
	public static List<String> readFile(File source) throws IOException {
		List<String> data = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
			String s;
			while ((s = reader.readLine()) != null) {
				data.add(s);
			}
		}
		return data;
	}

	public static void writeFile(List<String> data, File destination) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
			for (String s : data) {
				writer.write(s);
				writer.newLine();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		File source = new File("bin\\ocp\\ch8\\IO\\WorkingWithStreams\\FileStream.class"); 
		File destination = new File("src\\ocp\\ch8\\IO\\WorkingWithStreams\\FileStreamCopy.txt");
		List<String> data = readFile(source);
		for (String record : data) {
			out.println(record);
		}
		writeFile(data, destination);
	}
}