import java.util.Scanner;
import java.io.*;

public class URLDissector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url;
		Scanner fileScan, urlScan;
		try {
			fileScan = new Scanner(new File("websites.inp"));
			while (fileScan.hasNext()) {
				url = fileScan.nextLine();
				System.out.println("URL: " + url);
				urlScan = new Scanner(url);
				urlScan.useDelimiter("/");

				while (urlScan.hasNext())
					System.out.println(" " + urlScan.next());
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
