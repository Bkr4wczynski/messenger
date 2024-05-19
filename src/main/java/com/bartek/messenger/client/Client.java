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
        dataOutputStream.writeUTF("Bartek");
        dataOutputStream.writeUTF("Dupa12345");
        closeStreams();
    }
    public void closeStreams(){
        try {
            dataOutputStream.close();
            dataInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
