package ocp.ch8.IO.UnderstandingFilesAndDirectories;

import static java.lang.System.out;
import java.io.File;

public class IntroducingFileClass {

	public static void main(String[] args) {
		out.println(System.getProperty("file.separator"));
		out.println(java.io.File.separator);
		File file = new File("/home/smith/data/zoo.txt");
		out.println(file.exists());

		file = new File("/home/smith/data/zoo.txt");
		out.println(file.exists());

		File parent = new File("/home/smith");
		File child = new File(parent, "data/zoo.txt");

	}

}

class ReadFileInformation {
	public static void main(String[] args) {
		File file = new File("C:\\logs");
		out.println("File Exists: " + file.exists());
		if (file.exists()) {
			out.println("Absolute Path: " + file.getAbsolutePath());
			out.println("Is Directory: " + file.isDirectory());
			out.println("Parent Path: " + file.getParent());
			if (file.isFile()) {
				out.println("File size: " + file.length());
				out.println("File LastModified: " + file.lastModified());
			} else {
				for (File subfile : file.listFiles()) {
					out.println("\t" + subfile.getName());
				}
			}
		}
	}
}
