package io.conan.callback;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * Created by Ai Lun on 2020-08-07.
 */
public interface NewConnectionCallback {

    public void callback(int sockfd, InetSocketAddress peerAddr);

}
