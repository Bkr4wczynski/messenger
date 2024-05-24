package com.bartek.messenger.client;

import com.bartek.messenger.dataRepresentation.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private Socket socket;
    private InetAddress ip;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private User currentUser;

    public Client(InetAddress ip, int portNumber) throws IOException {
        this.ip = ip;
        this.socket = new Socket(ip, portNumber);
        this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        this.objectInputStream = new ObjectInputStream(socket.getInputStream());
    }

    void startClientService() throws IOException {
        System.out.println("Client service has started");
        Thread clientThread = new Thread(new ClientRunnable(socket, objectInputStream));
        clientThread.start();
    }

    public User getUserByUsername(String username) throws ClassNotFoundException {
        try {
            objectOutputStream.writeUTF("getUserByUsername");
            objectOutputStream.writeUTF(username);
            objectOutputStream.flush();
            Object object = objectInputStream.readObject();
            System.out.println(object);
            return (User) object;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean loginUser(String username, String password, String type) {
        // IF YOU ARE GOING TO TOUCH THIS VERY FUNCTION, DO IT VERY I MEAN LITERALLY EXTREMELY CAREFUL OR THE WHOLE APP BREAKS!!!
        try {
            objectOutputStream.writeUTF(username);
            objectOutputStream.writeUTF(password);
            objectOutputStream.writeUTF(type);
            objectOutputStream.flush();
            boolean result = objectInputStream.readUTF().equals("Success");
            if (!result)
                return false;
            currentUser = (User) objectInputStream.readObject();
            startClientService();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeStreams() {
        try {
            objectOutputStream.close();
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
