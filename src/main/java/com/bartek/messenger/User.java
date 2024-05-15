package com.bartek.messenger;

import java.util.HashSet;
import java.util.Set;

public class User {
    public String username;
    private final Set<User> friends;
    private final Set<User> blocked;
    private final Set<User> muted;
    private boolean online;

    public User(String username) {
        this.username = username;
        friends = new HashSet<>();
        blocked = new HashSet<>();
        muted = new HashSet<>();
    }
    public void addFriend(User user){
        friends.add(user);
    }
    public void removeFriend(User user){
        friends.remove(user);
    }
    public void block(User user){
        friends.remove(user);
        blocked.add(user);
    }
    public void unBlock(User user){
        blocked.remove(user);
    }
    public void mute(User user){
        muted.add(user);
    }
    public void unMute(User user){
        muted.remove(user);
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

    public Set<User> getFriends() {
        return friends;
    }

    public Set<User> getBlocked() {
        return blocked;
    }

    public Set<User> getMuted() {
        return muted;
    }
}
