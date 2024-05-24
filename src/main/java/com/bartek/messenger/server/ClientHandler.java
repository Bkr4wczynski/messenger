package com.bartek.messenger.server;

import com.bartek.messenger.dataRepresentation.Gender;
import com.bartek.messenger.dataRepresentation.User;
import com.bartek.messenger.database.MessengerDatabaseDAO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private final Socket clientSocket;
    private final DataInputStream dataInputStream;
    private final DataOutputStream dataOutputStream;
    private final MessengerDatabaseDAO messengerDatabaseDAO;
    private String username;

    public ClientHandler(Socket clientSocket,
                         DataInputStream dataInputStream,
                         DataOutputStream dataOutputStream,
                         MessengerDatabaseDAO messengerDatabaseDAO) {
        this.clientSocket = clientSocket;
        this.dataInputStream = dataInputStream;
        this.dataOutputStream = dataOutputStream;
        this.messengerDatabaseDAO = messengerDatabaseDAO;
    }

    @Override
    public void run() {
        System.out.println("Client handler has started");
        messengerDatabaseDAO.openConnection();
        performLoggingService();
        while (true){
            try {
                String output = dataInputStream.readUTF();
                System.out.println(output);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
        System.out.println("Past loop");
        User currentUser = messengerDatabaseDAO.getUser(username);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
            objectOutputStream.writeObject(currentUser);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(currentUser);
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
            messengerDatabaseDAO.closeConnection();
            System.out.println("terminated connection for client: "+clientSocket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
