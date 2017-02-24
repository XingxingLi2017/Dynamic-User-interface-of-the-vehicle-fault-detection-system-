package CustomComponents;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadWebsite {

	ArrayList<String> website;
	public ReadWebsite() throws IOException{
		// TODO Auto-generated constructor stub
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Website.txt"));
			website = new ArrayList<>();
			String s1 = null;
			s1 = reader.readLine();
			while (s1 != null) {
				website.add(s1);
				s1 = reader.readLine();
			}
		//	System.out.println(website);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<String> getWebsite() {
		return website;
	}
}
