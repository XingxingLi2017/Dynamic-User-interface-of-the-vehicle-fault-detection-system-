package CustomComponents;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import com.oracle.jrockit.jfr.client.FlightRecorderClient;

public class WriteWebsite {

	public static void writeWebsite(ArrayList<String> website) throws FileNotFoundException
	{
		FileOutputStream writerFileOutputStream = new FileOutputStream("Website.txt");
		PrintStream printStream = new PrintStream(writerFileOutputStream);
		for(String s: website)
		{
			printStream.println(s);
		}
	}
}
