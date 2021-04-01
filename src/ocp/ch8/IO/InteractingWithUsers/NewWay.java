package ocp.ch8.IO.InteractingWithUsers;

import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;

public class NewWay {

	public static void main(String[] args) {
		// format() method directly.
		// printf() same as format(). //no locale variable
		// reader() return a PrintReader
		// writer() return a PrintWriter
		// flush() forces any buffered output to be written immediately
		// readLine() retrieves a single line of text from the user, Enter key terminates it.
		// readPassword() echoing is disabled.
	}
}

class ConsoleReadInputSample {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Console console = System.console(); // Console class is a singleton
		if (console == null) {
			throw new RuntimeException("Console not available");
		} else {
			console.writer().print("How excited are you about your trip today? ");
			console.flush();
			String excitementAnswer = console.readLine();
			String name = console.readLine("Please enter your name: ");
			Integer age = null;
			console.writer().print("What is your age? ");
			console.flush();
			BufferedReader reader = new BufferedReader(console.reader());
			String value = reader.readLine();
			age = Integer.valueOf(value);
			console.writer().println();
			console.format("Your name is " + name);
			console.writer().println();
			console.format("Your age is " + age);
			console.printf("Your excitement level is: " + excitementAnswer);
		}
	}
}

class SystemInSample {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String userInput = reader.readLine();
		out.println("You entered the following: " + userInput);
	}
}

class ConsoleSample {
	public static void main(String[] args) {
		Console console = System.console();
		if (console != null) {
			String userInput = console.readLine();
			console.writer().println("You entered the following: " + userInput);
		} else {
			out.println("Console not available: " + System.console());
		}
	}
}

class ConsoleSamplePrint {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Console console = System.console();
		if (console == null) {
			throw new RuntimeException("Console not available");
		} else {
			console.writer().println("Welcome to Our Zoo!");
			console.format("Our zoo has 391 animals and employs 25 people.");
			console.writer().println();
			console.printf("The zoo spans 128.91 acres.");
		}
		console.writer().format(new Locale("fr", "CA"),"Hello World");
		console.format("Hello World");
	}
}

class PasswordCompareSample {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Console console = System.console();
		if (console == null) {
			throw new RuntimeException("Console not available");
		} else {
			char[] password = console.readPassword("Enter your password: ");

			console.format("Enter your password again: ");
			console.flush();
			char[] verify = console.readPassword();
			boolean match = Arrays.equals(password, verify);
// Immediately clear passwords from memory
			for (int i = 0; i < password.length; i++) {
				password[i] = 'x';
			}
			for (int i = 0; i < verify.length; i++) {
				verify[i] = 'x';
			}
			console.format("Your password was " + (match ? "correct" : "incorrect"));
		}
	}
}