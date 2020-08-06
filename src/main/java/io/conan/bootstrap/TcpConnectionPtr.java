package io.conan.bootstrap;

import lombok.Getter;
import lombok.Setter;
import sun.rmi.transport.tcp.TCPConnection;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import static io.conan.bootstrap.StateE.kConnected;

/**
 * Created by Ai Lun on 2020-08-06.
 */
@Getter
@Setter
public class TcpConnectionPtr {

    private TCPConnection conn;

    private InetSocketAddress localAddress;

    private InetSocketAddress peerAddress;

    private volatile StateE state;

    public TcpConnectionPtr(TCPConnection conn) {
        this.conn = conn;
    }

    public boolean connected() {
        return state == kConnected;
    }

}
