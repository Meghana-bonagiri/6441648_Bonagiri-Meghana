import java.io.*;
import java.net.*;

public class Q35_TCPChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started. Waiting for client...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        Thread receiveThread = new Thread(() -> {
            try {
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Client: " + line);
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
