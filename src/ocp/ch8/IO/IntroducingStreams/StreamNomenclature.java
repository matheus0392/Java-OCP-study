package ocp.ch8.IO.IntroducingStreams;

public class StreamNomenclature {

	public static void main(String[] args) {
		
		//FileReader is for string/char; not byte input
		/** new BufferedInputStream(new FileReader("zoo-data.txt")); */ // DOES NOT COMPILE
		
		//FileOutputStream is for bytes; not string/char input
		/** new BufferedWriter(new FileOutputStream("zoo-data.txt"));  */ // DOES NOT COMPILE
		
		//output/input?
		/** new ObjectInputStream(new FileOutputStream("zoo-data.txt")); */ // DOES NOT COMPILE
		
		//interface not implemented
		/** new BufferedInputStream(new InputStream()); */ // DOES NOT COMPILE

		/*  ■■ A class with the word InputStream or OutputStream in its name is used for reading or
			writing binary data, respectively.
			■■ A class with the word Reader or Writer in its name is used for reading or writing
			character or string data, respectively.
			■■ Most, but not all, input classes have a corresponding output class.
			■■ A low-level stream connects directly with the source of the data.
			■■ A high-level stream is built on top of another stream using wrapping.
			■■ A class with Buffered in its name reads or writes data in groups of bytes or characters
			and often improves performance in sequential file systems.
			*/
	}

}
