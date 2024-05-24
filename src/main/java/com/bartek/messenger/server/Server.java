package com.bartek.messenger.server;

import com.bartek.messenger.client.ClientRunnable;
import com.bartek.messenger.database.MessengerDatabaseDAO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static final int PORT = 5056;
    public static void main(String[] args) {
        Socket socket;
        List<ClientHandler> clientHandlerList = new ArrayList<>();
        try (
                ServerSocket serverSocket = new ServerSocket(PORT);
                MessengerDatabaseDAO messengerDatabaseDAO = new MessengerDatabaseDAO()
        ){
            System.out.println("Server is open running");
            while (true) {
                socket = serverSocket.accept();
                System.out.println("Connection established with client: "+socket.getInetAddress());
                System.out.println("Assigning new thread for client...");
                ClientHandler clientHandler = new ClientHandler(socket, messengerDatabaseDAO, clientHandlerList);
                clientHandlerList.add(clientHandler);
                Thread thread = new Thread(clientHandler);
                thread.start();
                System.out.println("Thread started successfully!");
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
