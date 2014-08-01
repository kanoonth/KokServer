import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerThread extends Thread {
	
	private Socket socket;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		super.run();
		try {
			String name = socket.getInetAddress().toString();
			System.out.println( name + " มาแล้วนะ" );

			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println("Welcome to my server");
			out.flush();
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println( name + "บอกว่า " + in.read() );
		} catch( Exception e) {
			
		}
	}
	
}
