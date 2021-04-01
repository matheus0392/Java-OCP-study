package ocp.ch8.IO.IntroducingStreams;

import static java.lang.System.out;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CommonStreamOperations {

	public static void main(String[] args) throws IOException {
		/** InputStream and Reader **/

		// flush() requests that all accumulated data be written immediately to disk.
		// markSupported() returns true only if mark() is supported
		// mark(int) move the stream back to an earlier position
		// reset() move the stream back to an earlier position
		//

		InputStream is = new ByteArrayInputStream("ABCD".getBytes());
		out.print((char) is.read());
		if (is.markSupported()) {
			is.mark(0);
			out.print((char) is.read());
			out.print((char) is.read());
			is.reset();
		}
		out.print((char) is.read());
		out.print((char) is.read());
		out.print((char) is.read());
		out.println();
		// skip(long) skips over a certain number of bytes.
		// It returns a long value, which indicates the number of bytes that were actually skipped.

		is = new ByteArrayInputStream("TIGERS".getBytes());
		out.print((char) is.read());
		is.skip(2);
		is.read();
		out.print((char) is.read());
		out.print((char) is.read());
	}

}
