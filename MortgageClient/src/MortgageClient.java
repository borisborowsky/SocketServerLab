import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

class MortgageClient {
	public static void main(String[] args) {
		String hostName = "127.0.0.1";
		int portNumber = 44444;
		
		Socket clientSocket;
		BufferedReader in;
		BufferedReader stdIn;
		PrintWriter out;
		
		try {
			System.out.println("Client program!!");
			clientSocket = new Socket(hostName, portNumber);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			out.println("initCalculation");
			
			System.out.println("Enter the loan percentage rate:");
			out.println(stdIn.readLine());
			
			System.out.println("Enter the loan amount:");
			out.println(stdIn.readLine());
			
			System.out.println("Enter the loan duration:");
			out.println(stdIn.readLine());
			
			System.out.println("Server says mortgage repayment is: " + in.readLine());
		} catch (UnknownHostException e) {
			System.exit(1);
		} catch (IOException e) {
			System.exit(1);
		}
		
	}
}










