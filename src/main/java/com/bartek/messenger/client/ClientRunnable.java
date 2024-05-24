package com.bartek.messenger.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientRunnable implements Runnable {
    private Socket socket;
    private ObjectInputStream objectInputStream;

    public ClientRunnable(Socket socket, ObjectInputStream objectInputStream) {
        this.socket = socket;
        this.objectInputStream = objectInputStream;
    }

    @Override
    public void run() {
        while (true){
            String response = null;
            /*
            try {
                response = objectInputStream.readUTF();
                System.out.println(response);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }*/
        }

    }
}
