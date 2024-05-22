package com.bartek.messenger.utils;

import com.bartek.messenger.MessengerApp;
import com.bartek.messenger.client.Client;
import com.bartek.messenger.dataRepresentation.User;

public class UserGetter {
    public static User GET_CURRENT_USER(){
        // database logic
        Client client = MessengerApp.client;
        return client.getCurrentUser();
    }
}
