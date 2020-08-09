package io.conan.bootstrap;


import io.conan.callback.*;
import io.conan.channel.EventLoop;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Ai Lun on 2020-08-06.
 */
@Slf4j
@Getter
@Setter
public class TcpConnection {

    private EventLoop eventLoop;

    private String connName;

    private Socket socket;

    private InetSocketAddress localAddr;

    private InetSocketAddress peerAddr;

    private ConnectionCallback connectionCallback;

    private MessageCallback messageCallback;

    private WriteCompleteCallback writeCompleteCallback;

    private HighWaterMarkCallback highWaterMarkCallback;

    private CloseCallback closeCallback;

    public TcpConnection(EventLoop eventLoop, String connName, Socket socket,
                         InetSocketAddress localAddr, InetSocketAddress peerAddr) {
        this.eventLoop = eventLoop;
        this.connName = connName;
        this.socket = socket;
        this.localAddr = localAddr;
        this.peerAddr = peerAddr;
    }

    public static ConnectionCallback defaultConnectionCallback = new ConnectionCallback() {
        @Override
        public void callback(TcpConnectionPtr conn) {
            log.info("{} -> {} is {}", conn.getLocalAddress().getAddress().getAddress(),
                    conn.getPeerAddress().getAddress().getAddress(),
                    conn.connected() ? "UP" : "DOWN");
        }
    };

}
