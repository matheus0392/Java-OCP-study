package ocp.ch6.ExceptionsAndAssertions.UsingMultiCatch;

import static java.lang.System.out;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class UsingMultiCatch {

	public static void main(String[] args) {
		try {
			Path path = Paths.get("dolphinsBorn.txt");
			String text = new String(Files.readAllBytes(path));
			LocalDate date = LocalDate.parse(text);
			System.out.println(date);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			e = new IOException();
			throw new RuntimeException(e);
		}

		//equivalent
		try {
			Path path = Paths.get("dolphinsBorn.txt");
			String text = new String(Files.readAllBytes(path));
			LocalDate date = LocalDate.parse(text);
			System.out.println(date);
		} catch (DateTimeParseException | IOException  e) { // there is only one variable
			e.printStackTrace();
			/** e = new IOException(); */ //mult-catch  //DOES NOT COMPILE
			//throw new RuntimeException(e);
			
			for (Throwable t : e.getSuppressed())
				out.println("suppressed: " + t.getMessage());
		}

	}

}
