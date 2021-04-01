package ocp.ch8.IO.WorkingWithStreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class CopyFileSample {
	public static void copy(File source, File destination) throws IOException {
		try (InputStream in = new FileInputStream(source); OutputStream out = new FileOutputStream(destination)) {
			int b;
			while ((b = in.read()) != -1) {
				out.write(b);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		File source = new File("bin\\ocp\\ch8\\IO\\WorkingWithStreams\\FileStream.class");// java.io.FileNotFoundException ?
		File destination = new File("src\\ocp\\ch8\\IO\\WorkingWithStreams\\ZooCopy.txt");
		copy(source, destination);
	}
}

class CopyBufferFileSample {
	public static void main(String[] args) throws IOException {
		File source = new File("bin\\ocp\\ch8\\IO\\WorkingWithStreams\\FileStream.class"); 
		File destination = new File("src\\ocp\\ch8\\IO\\WorkingWithStreams\\ZooCopy.txt");
		copy(source, destination);
	}

	public static void copy(File source, File destination) throws IOException {
		try (InputStream in = new BufferedInputStream(new FileInputStream(source));
				OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
			byte[] buffer = new byte[1024];
			int lengthRead;
			while ((lengthRead = in.read(buffer)) > 0) {
				out.write(buffer, 0, lengthRead);
				out.flush();
			}
		}
	}
}