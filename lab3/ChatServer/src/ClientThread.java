import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class ClientThread implements Runnable {
    private Socket socket;
    private ChatServer server;
    private int clientNumber;

    public ClientThread(Socket socket, ChatServer server, int clientNumber) {
        this.socket = socket;
        this.server = server;
        this.clientNumber = clientNumber;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

            new PrintWriter(socket.getOutputStream(), true).printf("Client #%d%n", clientNumber);
            server.sendMessageToAllClientsExcept(String.format("Client #%d connected.", clientNumber), clientNumber);

            System.out.printf("Client %d connected.%n", clientNumber);

            while (true) {
                String message = input.readLine();

                System.out.printf("Client #%d: %s%n", clientNumber, message);
                server.sendMessageToAllClientsExcept(String.format("Client #%d: %s", clientNumber, message), clientNumber);
            }
        }
        catch (IOException e) {
            System.out.printf("Client #%d disconnected.", clientNumber);
            server.sendMessageToAllClientsExcept(String.format("Client #%d disconnected", clientNumber), clientNumber);
            this.server.removeClient(clientNumber);
        }
    }
}
