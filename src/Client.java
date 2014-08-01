import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		Socket server = new Socket("127.0.0.1", 7777);
		InputStream in = server.getInputStream();
		OutputStream out = server.getOutputStream();

		PrintStream serverScreen = new PrintStream(out);
		String formServer = convertStreamToString(in);
		serverScreen.println(scan.nextLine());
		System.out.println(formServer);
		serverScreen.close();
		server.close();
	}
	
	static String convertStreamToString(java.io.InputStream is) {
	    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	    return s.hasNext() ? s.next() : "";
	}
}
