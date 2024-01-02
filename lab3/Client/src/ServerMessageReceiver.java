import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerMessageReceiver implements Runnable {
    private Socket socket;

    public ServerMessageReceiver(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

            while (true) {
                String message = reader.readLine();
                if (message != null) {
                    System.out.println(message);
                }
            }
        }
        catch (IOException e) {
            System.out.printf("Could not receive message: %s%n", e.getMessage());
        }
    }
}
