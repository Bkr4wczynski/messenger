package com.bartek.messenger.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private final Socket clientSocket;
    private final DataInputStream dataInputStream;
    private final DataOutputStream dataOutputStream;

    public ClientHandler(Socket clientSocket, DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        this.clientSocket = clientSocket;
        this.dataInputStream = dataInputStream;
        this.dataOutputStream = dataOutputStream;
    }

    @Override
    public void run() {
        String received;

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
