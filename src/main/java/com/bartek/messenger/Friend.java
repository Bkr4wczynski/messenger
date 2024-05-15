package com.bartek.messenger;

public class Friend extends User{
    public User friendOf;
    private boolean isMuted;

    public Friend(String username, User friendOf) {
        super(username);
        this.friendOf = friendOf;
    }

    public boolean isMuted() {
        return isMuted;
    }

    public void setMuted(boolean muted) {
        isMuted = muted;
    }
}
