// Name: Andrew Kigathi
// Student Number: 220277
// Date: 11/06/2026

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {
    private static final int PORT = 5000;
    private static final Set<ClientHandler> clients = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        System.out.println("Chat server running on port " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler client = new ClientHandler(clientSocket);
                clients.add(client);
                new Thread(client).start();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    private static void broadcast(String message, ClientHandler sender) {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                if (client != sender) {
                    client.send(message);
                }
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private PrintWriter out;
        private String name;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

                out = writer;
                out.println("Enter your name:");
                name = in.readLine();

                if (name == null || name.isBlank()) {
                    name = "Anonymous";
                }

                System.out.println(name + " connected from " + socket.getInetAddress().getHostAddress());
                out.println("Welcome, " + name + ". Type /quit to leave.");
                String joinMessage = name + " joined the chat.";
                System.out.println(joinMessage);
                broadcast(joinMessage, this);

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("/quit")) {
                        break;
                    }
                    String chatMessage = name + ": " + message;
                    System.out.println(chatMessage);
                    broadcast(chatMessage, this);
                }
            } catch (IOException e) {
                System.out.println("Client connection error: " + e.getMessage());
            } finally {
                clients.remove(this);
                if (name != null) {
                    String leaveMessage = name + " left the chat.";
                    System.out.println(leaveMessage);
                    broadcast(leaveMessage, this);
                }
                closeSocket();
            }
        }

        void send(String message) {
            if (out != null) {
                out.println(message);
            }
        }

        private void closeSocket() {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Could not close socket: " + e.getMessage());
            }
        }
    }
}
