package com.bartek.messenger;

import java.util.HashSet;
import java.util.Set;

public class User {
    public String username;
    private final Set<Friend> friends;
    private final Set<User> blocked;
    private boolean online;

    public User(String username) {
        this.username = username;
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
