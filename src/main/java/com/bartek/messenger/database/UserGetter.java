package com.bartek.messenger.database;

import com.bartek.messenger.User;

public class UserGetter {
    public static User GET_CURRENT_USER(){
        // database logic
        return new User("cwaniak");
    }
}
