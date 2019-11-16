import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

class SocketServer {
	private final int portNumber = 44444;
	private ServerSocket serverSocket = null;
	private static final int NTHREADS = 100;
	private static final ExecutorService exec 
				= Executors.newFixedThreadPool(NTHREADS);
	
	void runServer() {
		try {
			serverSocket = new ServerSocket(portNumber);
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		while (!exec.isShutdown()) {
			try {
				final Socket clientSocket = serverSocket.accept();
				exec.execute(new MortgageRunnable(clientSocket));
			} catch(RejectedExecutionException | IOException e) {
				if (!exec.isShutdown())
					System.out.println("Task submission rejected" + e);
				System.out.println(e.getMessage());
			}
		}
	}
	
	void stop() {
		exec.shutdown();
	}
}
















