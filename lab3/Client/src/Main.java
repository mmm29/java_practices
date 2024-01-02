//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ChatClient client = ChatClient.connect(1838);
        if (client != null) {
            client.start();
            System.out.println("Client connected.");
        }
    }
}