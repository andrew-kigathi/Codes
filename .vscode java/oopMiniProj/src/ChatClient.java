// Name: Andrew Kigathi
// Student Number: 220277
// Date: 11/06/2026

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        String serverAddress = args.length > 0 ? args[0] : "10.55.55.189";

        try (
                Socket socket = new Socket(serverAddress, PORT);
                BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))) {

            Thread listener = new Thread(() -> {
                try {
                    String message;
                    while ((message = serverIn.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            });
            listener.setDaemon(true);
            listener.start();

            String input;
            while ((input = keyboard.readLine()) != null) {
                serverOut.println(input);
                if (input.equalsIgnoreCase("/quit")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
