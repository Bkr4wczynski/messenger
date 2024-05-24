package com.bartek.messenger.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientRunnable implements Runnable {
    private Socket socket;
    private DataInputStream dataInputStream;

    public ClientRunnable(Socket socket, DataInputStream dataInputStream) {
        this.socket = socket;
        this.dataInputStream = dataInputStream;
    }

    @Override
    public void run() {
        while (true){
            try {
                String response = dataInputStream.readUTF();
                System.out.println(response);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
