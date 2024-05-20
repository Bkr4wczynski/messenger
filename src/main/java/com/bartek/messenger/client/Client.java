package com.bartek.messenger.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private Socket socket;
    private InetAddress ip;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public Client(InetAddress ip, int portNumber) throws IOException {
        this.ip = ip;
        this.socket = new Socket(ip, portNumber);
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }

    public void startClientService() throws IOException {
        System.out.println("Client service has started");
    }
    public boolean loginUser(String username, String password, String type){
        try {
            dataOutputStream.writeUTF(username);
            dataOutputStream.writeUTF(password);
            dataOutputStream.writeUTF(type);
            return dataInputStream.readUTF().equals("Success");
        } catch (IOException e) {
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
}
