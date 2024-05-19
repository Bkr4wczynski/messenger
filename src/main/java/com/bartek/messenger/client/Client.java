package com.bartek.messenger.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

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
        try {
            System.out.println("Client service started");

            System.out.println(dataInputStream.readUTF());
            dataOutputStream.writeUTF("12345");
            dataInputStream.close();
            dataOutputStream.close();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
