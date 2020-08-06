package io.conan.bootstrap;


import io.conan.callback.ConnectionCallback;
import io.conan.channel.EventLoop;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;

/**
 * Created by Ai Lun on 2020-08-06.
 */
@Slf4j
public class TcpConnection {

    private EventLoop eventLoop;

    private String connName;

    private InetAddress address;

    public static ConnectionCallback defaultConnectionCallback = new ConnectionCallback() {
        @Override
        public void callback(TcpConnectionPtr conn) {
            log.info("{} -> {} is {}", conn.getLocalAddress().getAddress().getAddress(),
                    conn.getPeerAddress().getAddress().getAddress(),
                    conn.connected() ? "UP" : "DOWN");
        }
    };


}
