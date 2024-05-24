package com.bartek.messenger.server;

import com.bartek.messenger.dataRepresentation.Gender;
import com.bartek.messenger.dataRepresentation.User;
import com.bartek.messenger.database.MessengerDatabaseDAO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable{
    private final Socket clientSocket;
    private final DataInputStream dataInputStream;
    private final DataOutputStream dataOutputStream;
    private final MessengerDatabaseDAO messengerDatabaseDAO;
    private String username;
    private List<ClientHandler> clientHandlers;
    private ObjectOutputStream objectOutputStream;

    public ClientHandler(Socket clientSocket,
                         DataInputStream dataInputStream,
                         DataOutputStream dataOutputStream,
                         MessengerDatabaseDAO messengerDatabaseDAO,
                         List<ClientHandler> clientHandlers) {
        this.clientSocket = clientSocket;
        this.dataOutputStream = dataOutputStream;
        this.dataInputStream = dataInputStream;
        this.messengerDatabaseDAO = messengerDatabaseDAO;
        this.clientHandlers = clientHandlers;
        try {
            this.objectOutputStream = new ObjectOutputStream(dataOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        System.out.println("Client handler has started");
        messengerDatabaseDAO.openConnection();
        performLoggingService();
        while (true){
            try {
                String command = dataInputStream.readUTF();
                String inputData = dataInputStream.readUTF();
                if (command.equals("getUserByUsername")){
                    getUserByUsername(inputData);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void getUserByUsername(String username){
        User user = messengerDatabaseDAO.getUser(username);
        try {
            objectOutputStream.writeObject(user);
            objectOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private void performLoggingService(){
        boolean hasUserLoggedIn = false;
        while (!hasUserLoggedIn){
            try {
                if (loginUser()){
                    dataOutputStream.writeUTF("Success");
                    hasUserLoggedIn = true;
                }
                else {
                    dataOutputStream.writeUTF("Fail");
                }
            } catch (IOException e) {
                System.out.println("User failed to login!");
                return;
            }
        }
        getUserByUsername(username);
    }
    private boolean loginUser() throws IOException{
        username = dataInputStream.readUTF();
        String password = dataInputStream.readUTF();
        String type = dataInputStream.readUTF();
        if (type.equals("signup"))
            return messengerDatabaseDAO.addNewUserToDatabase(username, password, Gender.male);
        return messengerDatabaseDAO.loginUser(username, password);
    }

    public void terminateConnection(){
        try {
            clientSocket.close();
            dataOutputStream.close();
            dataInputStream.close();
            objectOutputStream.close();
            messengerDatabaseDAO.closeConnection();
            System.out.println("terminated connection for client: "+clientSocket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
