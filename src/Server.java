import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
	public static void main(String[] args) throws IOException {
		
		int portNumber = 7777;
		ServerSocket serverSocket = new ServerSocket(portNumber);
		System.out.println("Server is running at port" + portNumber);
		
		while(true) {
			Socket client = serverSocket.accept();
			ServerThread st = new ServerThread(client);
			st.start();
		}

	}


}
