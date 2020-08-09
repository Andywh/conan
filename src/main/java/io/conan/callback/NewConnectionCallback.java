package io.conan.callback;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Ai Lun on 2020-08-07.
 */
public interface NewConnectionCallback {

    public void callback(Socket socket, InetSocketAddress peerAddr);

}
