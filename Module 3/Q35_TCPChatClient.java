import java.io.*;
import java.net.*;

public class Q35_TCPChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        System.out.println("Connected to server.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        Thread receiveThread = new Thread(() -> {
            try {
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Server: " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread sendThread = new Thread(() -> {
            try {
                String line;
                while ((line = consoleInput.readLine()) != null) {
                    out.write(line);
                    out.newLine();
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        receiveThread.start();
        sendThread.start();
    }
}
