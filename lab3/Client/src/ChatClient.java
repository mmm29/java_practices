import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
    private Socket socket;

    ChatClient(Socket socket) {
        this.socket = socket;
    }

    public static ChatClient connect(int port) {
        try {
            Socket socket = new Socket("127.0.0.1", port);
            return new ChatClient(socket);
        }
        catch (UnknownHostException e) {
            System.out.printf("Unknown host exception: %s%n", e.getMessage());
            return null;
        }
        catch (IOException e) {
            System.out.printf("IO error: %s%n", e.getMessage());
            return null;
        }
    }

    public void start() {
        Thread userInputSenderThread = new Thread(new UserInputSender(this.socket));
        userInputSenderThread.setDaemon(true);
        userInputSenderThread.start();

        Thread serverMessageReceiverThread = new Thread(new ServerMessageReceiver(this.socket));
        serverMessageReceiverThread.start();
    }
}
