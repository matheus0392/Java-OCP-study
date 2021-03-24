package ocp.ch6.ExceptionsAndAssertions.UsingTryWithResources;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class UsingTryWithResources {

	public static void main(String[] args) throws IOException {
		Path path1 = Paths.get(".\\src\\ocp\\ch6\\ExceptionsAndAssertions\\Chapiter 6.txt");
		Path path2 = Paths.get(".\\src\\ocp\\ch6\\ExceptionsAndAssertions\\UsingTryWithResources\\test.txt");
		new UsingTryWithResources().oldApproach(path1, path2);

		new UsingTryWithResources().newApproach(path1, path2);

		try (Scanner s = new Scanner(System.in)) {
			s.nextLine();
		} catch (Exception e) {
			/** s.nextInt(); */ // DOES NOT COMPILE
		} finally {
			/** s.nextInt(); */ // DOES NOT COMPILE
		}
	}

	public void oldApproach(Path path1, Path path2) throws IOException {
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			in = Files.newBufferedReader(path1);
			out = Files.newBufferedWriter(path2);
			out.write(in.readLine());
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}

	// equivalent
	public void newApproach(Path path1, Path path2) throws IOException {
		try (BufferedReader in = Files.newBufferedReader(path1); BufferedWriter out = Files.newBufferedWriter(path2)) {
			out.write(in.readLine());
		}
	}
}
