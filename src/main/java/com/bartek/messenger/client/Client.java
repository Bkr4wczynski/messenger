package com.bartek.messenger.client;

import com.bartek.messenger.dataRepresentation.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private Socket socket;
    private InetAddress ip;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private User currentUser;

    public Client(InetAddress ip, int portNumber) throws IOException {
        this.ip = ip;
        this.socket = new Socket(ip, portNumber);
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }

    void startClientService() throws IOException {
        System.out.println("Client service has started");
        Thread clientThread = new Thread(new ClientRunnable(socket, dataInputStream));
        clientThread.start();
        dataOutputStream.writeUTF("Hejo jestem "+currentUser.username);
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
            currentUser = (User) new ObjectInputStream(dataInputStream).readObject();
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
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public User getCurrentUser() {
        return currentUser;
    }
}
