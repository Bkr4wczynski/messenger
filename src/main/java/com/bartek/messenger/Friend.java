package com.bartek.messenger;

public class Friend extends User{
    public User friendOf;
    private boolean isMuted;

    public Friend(User friend, User friendOf) {
        super(friend.userID, friend.username, friend.gender, friend.createdAt);
        this.friendOf = friendOf;
    }

    public boolean isMuted() {
        return isMuted;
    }

    public void setMuted(boolean muted) {
        isMuted = muted;
    }
}
