package com.bartek.messenger.server;

import com.bartek.messenger.database.MessengerDatabaseDAO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static final int PORT = 1000;
    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(PORT);
                MessengerDatabaseDAO messengerDatabaseDAO = new MessengerDatabaseDAO()
        ){
            Socket socket;
            while (true) {
                socket = serverSocket.accept();
                System.out.println("Connection established with client: "+socket.getInetAddress());
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                System.out.println("Assigning new thread for client...");
                ClientHandler clientHandler = new ClientHandler(socket, dataInputStream, dataOutputStream);
                Thread thread = new Thread(clientHandler);
                thread.start();
                System.out.println("Thread started successfully!");
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
