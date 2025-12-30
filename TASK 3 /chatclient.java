import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);

        BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        new Thread(() -> {
            try {
                String msg;
                while ((msg = input.readLine()) != null) {
                    System.out.println(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        BufferedReader keyboard = new BufferedReader(
                new InputStreamReader(System.in));

        String message;
        while ((message = keyboard.readLine()) != null) {
            out.println(message);
        }
    }
}
