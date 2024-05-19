package com.bartek.messenger.server;

import com.bartek.messenger.database.Gender;
import com.bartek.messenger.database.MessengerDatabaseDAO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private final Socket clientSocket;
    private final DataInputStream dataInputStream;
    private final DataOutputStream dataOutputStream;
    private final MessengerDatabaseDAO messengerDatabaseDAO;

    public ClientHandler(Socket clientSocket, DataInputStream dataInputStream, DataOutputStream dataOutputStream, MessengerDatabaseDAO messengerDatabaseDAO) {
        this.clientSocket = clientSocket;
        this.dataInputStream = dataInputStream;
        this.dataOutputStream = dataOutputStream;
        this.messengerDatabaseDAO = messengerDatabaseDAO;
    }

    @Override
    public void run() {
        System.out.println("Client handler has started");
        try {
            System.out.println();
            messengerDatabaseDAO.openConnection();
            messengerDatabaseDAO.addNewUserToDatabase(dataInputStream.readUTF(), dataInputStream.readUTF(), Gender.Male);
            messengerDatabaseDAO.closeConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void terminateConnection(){
        try {
            clientSocket.close();
            dataOutputStream.close();
            dataInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
