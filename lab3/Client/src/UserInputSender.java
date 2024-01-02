import java.io.*;
import java.net.Socket;

public class UserInputSender implements Runnable {
    private Socket socket;

    public UserInputSender(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String message;

            try {
                message = stdin.readLine();
            }
            catch (IOException e) {
                System.err.println("Could not read user input.");
                break;
            }

            if (message == null) {
                System.out.println("Exit.");
                break;
            }

            try {
                new PrintWriter(this.socket.getOutputStream(), true).println(message);
            }
            catch (IOException e) {
                System.err.printf("Could not send message to server: %s%n", e);
            }
        }
    }
}
