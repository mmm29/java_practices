import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Map;
import java.util.TreeMap;

public class ChatServer implements Runnable {
    private Map<Integer, Socket> clients = new TreeMap<>();

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(1838);
            System.out.println("Server started. Waiting for clients.");

            int clientId = 1;

            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread clientThread = new Thread(new ClientThread(clientSocket, this, clientId));
                clientThread.setDaemon(true);
                clientThread.start();

                clients.put(clientId, clientSocket);
                clientId++;
            }

        } catch (SocketException e) {
            System.out.printf("Socket exception: %s%n", e.getMessage());
        }
        catch (IOException e) {
            System.out.printf("IO error: %s%n", e.getMessage());
        }
    }

    public void sendMessageToAllClientsExcept(String message, int clientNumber) {
        for (Map.Entry<Integer, Socket> entry : clients.entrySet()) {
            int thisClientId = entry.getKey();

            if (thisClientId == clientNumber)
                continue;

            Socket clientSocket = entry.getValue();

            try {
                new PrintWriter(clientSocket.getOutputStream(), true).println(message);
            }
            catch (IOException e) {
                System.err.printf("Could not send message to client #%d%n", thisClientId);
            }
        }
    }

    public void removeClient(int clientNumber) {
        try {
            this.clients.get(clientNumber).close();
        }
        catch (IOException e) {
            System.out.println("Could not close socket");
        }

        this.clients.remove(clientNumber);
    }
}
