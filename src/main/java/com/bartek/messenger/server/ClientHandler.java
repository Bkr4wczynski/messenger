package com.bartek.messenger.server;

import com.bartek.messenger.dataRepresentation.Gender;
import com.bartek.messenger.dataRepresentation.User;
import com.bartek.messenger.database.MessengerDatabaseDAO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final ObjectInputStream objectInputStream;
    private final ObjectOutputStream objectOutputStream;
    private final MessengerDatabaseDAO messengerDatabaseDAO;
    private String username;
    private List<ClientHandler> clientHandlers;

    public ClientHandler(Socket clientSocket,
                         MessengerDatabaseDAO messengerDatabaseDAO,
                         List<ClientHandler> clientHandlers) {
        this.clientSocket = clientSocket;
        this.messengerDatabaseDAO = messengerDatabaseDAO;
        this.clientHandlers = clientHandlers;
        try {
            this.objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            this.objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        System.out.println("Client handler has started");
        messengerDatabaseDAO.openConnection();
        performLoggingService();
        while (true) {
            try {
                String command = objectInputStream.readUTF();
                String inputData = objectInputStream.readUTF();
                if (command.equals("getUserByUsername")) {
                    getUserByUsername(inputData);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void getUserByUsername(String username) {
        User user = messengerDatabaseDAO.getUser(username);
        try {
            System.out.println(user.username);
            objectOutputStream.writeObject(user);
            objectOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void performLoggingService() {
        boolean hasUserLoggedIn = false;
        while (!hasUserLoggedIn) {
            try {
                if (loginUser()) {
                    objectOutputStream.writeUTF("Success");
                    objectOutputStream.flush();
                    hasUserLoggedIn = true;
                } else {
                    objectOutputStream.writeUTF("Fail");
                    objectOutputStream.flush();
                }
            } catch (IOException e) {
                System.out.println("User failed to login!");
                return;
            }
        }
        getUserByUsername(username);
    }

    private boolean loginUser() throws IOException {
        username = objectInputStream.readUTF();
        String password = objectInputStream.readUTF();
        String type = objectInputStream.readUTF();
        if (type.equals("signup"))
            return messengerDatabaseDAO.addNewUserToDatabase(username, password, Gender.male);
        return messengerDatabaseDAO.loginUser(username, password);
    }

    public void terminateConnection() {
        try {
            clientSocket.close();
            objectOutputStream.close();
            objectInputStream.close();
            messengerDatabaseDAO.closeConnection();
            System.out.println("terminated connection for client: " + clientSocket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
