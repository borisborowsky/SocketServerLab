import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class MortgageRunnable implements Runnable {

	protected Socket clientSocket = null;
	private Mortgage m;
	
	MortgageRunnable(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			if (in.readLine().contentEquals("initCalculation")) {
				String arg1, arg2, arg3;
				arg1 = in.readLine();
				arg2 = in.readLine();
				arg3 = in.readLine();
				
				double annualInterestRate = Double.parseDouble(arg1);
				double principleAmount = Double.parseDouble(arg2);
			    double durationYears = Double.parseDouble(arg3);
			    
			    this.m = new Mortgage(annualInterestRate, principleAmount, durationYears);
			}
			// Send the result to the client program.
			out.println(m.monthlyPayments());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}











