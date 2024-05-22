package com.bartek.messenger.dataRepresentation;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {
    public int userID;
    public String username;
    public Gender gender;
    public LocalDate createdAt;
    private final Set<Friend> friends;
    private final Set<User> blocked;
    private boolean online;

    public User(int userID, String username, Gender gender, LocalDate createdAt) {
        this.username = username;
        this.userID = userID;
        this.gender = gender;
        this.createdAt = createdAt;
        friends = new HashSet<>();
        blocked = new HashSet<>();
    }
    public void addFriend(User addedFriend){
        Friend friend = new Friend(addedFriend, this);
        friends.add(friend);
    }
    public void removeFriend(User removedFriend){
        Friend friend = new Friend(removedFriend, this);
        friends.remove(friend);
    }
    public void block(User user){
        this.removeFriend(user);
        blocked.add(user);
    }
    public void unBlock(User user){
        blocked.remove(user);
    }
    public void mute(User user){
        // logic
    }
    public void unMute(User user){
        // logic
    }
    public void goOnline(){
        online = true;
    }
    public void goOffline(){
        online = false;
    }

    public boolean isOnline() {
        return online;
    }

    public Set<Friend> getFriends() {
        return friends;
    }

    public Set<User> getBlocked() {
        return blocked;
    }
}
