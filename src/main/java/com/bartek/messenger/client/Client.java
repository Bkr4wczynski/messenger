package com.bartek.messenger.client;

import com.bartek.messenger.dataRepresentation.User;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private Socket socket;
    private InetAddress ip;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private ObjectInputStream objectInputStream;
    private User currentUser;
    private ClientRunnable clientRunnable;

    public Client(InetAddress ip, int portNumber) throws IOException {
        this.ip = ip;
        this.socket = new Socket(ip, portNumber);
        this.dataInputStream = new DataInputStream(socket.getInputStream());
        this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        this.objectInputStream = new ObjectInputStream(dataInputStream);
    }
    void startClientService() throws IOException {
        System.out.println("Client service has started");
        clientRunnable = new ClientRunnable(socket, dataInputStream);
        Thread clientThread = new Thread(clientRunnable);
        clientThread.start();
    }
    public User getUserByUsername(String username) throws ClassNotFoundException {
        try {
            dataOutputStream.writeUTF("getUserByUsername");
            dataOutputStream.writeUTF(username);
            dataOutputStream.flush();
            return (User) objectInputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean loginUser(String username, String password, String type){
        try {
            // IF YOU ARE GOING TO TOUCH THIS VERY FUNCTION, DO IT VERY I MEAN LITERALLY EXTREMELY CAREFUL OR THE WHOLE APP BREAKS!!!
            dataOutputStream.writeUTF(username);
            dataOutputStream.writeUTF(password);
            dataOutputStream.writeUTF(type);
            boolean result = dataInputStream.readUTF().equals("Success");
            if (!result)
                return false;
            currentUser = (User) objectInputStream.readObject();
            startClientService();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void closeStreams(){
        try {
            dataOutputStream.close();
            dataInputStream.close();
            objectInputStream.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public User getCurrentUser() {
        return currentUser;
    }
}
