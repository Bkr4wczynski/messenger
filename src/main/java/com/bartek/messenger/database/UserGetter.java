package com.bartek.messenger.database;

import com.bartek.messenger.Gender;
import com.bartek.messenger.User;

import java.time.LocalDateTime;

public class UserGetter {
    public static User GET_CURRENT_USER(){
        // database logic
        return new User(5, "cwaniak", Gender.Male, LocalDateTime.now());
    }
}
