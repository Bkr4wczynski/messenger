package com.bartek.messenger;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class User {
    public int userID;
    public String username;
    public Gender gender;
    public LocalDateTime createdAt;
    private final Set<Friend> friends;
    private final Set<User> blocked;
    private boolean online;

    public User(int userID, String username, Gender gender, LocalDateTime createdAt) {
        this.username = username;
        this.userID = userID;
        this.gender = gender;
        this.createdAt = createdAt;
        friends = new HashSet<>();
        blocked = new HashSet<>();
    }
    public void addFriend(User addedFriend){
        Friend friend = new Friend(addedFriend.username, this);
        friends.add(friend);
    }
    public void removeFriend(User removedFriend){
        Friend friend = new Friend(removedFriend.username, this);
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
