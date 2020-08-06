package io.conan.channel;

import io.conan.callback.NewConnectionCallback;

/**
 * Created by Ai Lun on 2020-08-06.
 */
public class Acceptor {

    private NewConnectionCallback newConnectionCallback;

    public NewConnectionCallback getNewConnectionCallback() {
        return newConnectionCallback;
    }

    public void setNewConnectionCallback(NewConnectionCallback newConnectionCallback) {
        this.newConnectionCallback = newConnectionCallback;
    }
}
