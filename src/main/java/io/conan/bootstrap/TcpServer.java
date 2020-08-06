package io.conan.bootstrap;

import io.conan.callback.ConnectionCallback;
import io.conan.callback.NewConnectionCallback;
import io.conan.channel.Acceptor;
import io.conan.channel.EventLoop;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import static io.conan.bootstrap.TcpConnection.defaultConnectionCallback;

/**
 * Created by Ai Lun on 2020-08-06.
 */
@Slf4j
public class TcpServer {

    // main eventloop
    private EventLoop loop;

    private String name;

    private InetAddress address;

    private Acceptor acceptor;

    private EventLoopThreadPool threadPool;

    private ConnectionCallback connectionCallback;

    private int nextConnId;

    private Socket socket;
    
    private String hostPort;

    public TcpServer(EventLoop loop,
                     InetAddress listenAddr,
                     String name, Acceptor acceptor,
                     EventLoopThreadPool threadPool,
                     int nextConnId) {
        this.loop = loop;
        this.hostPort = listenAddr.getHostAddress();
        this.name = name;
        this.acceptor = acceptor;
        this.threadPool = threadPool;
        this.connectionCallback = defaultConnectionCallback;
        this.nextConnId = nextConnId;
        acceptor.setNewConnectionCallback(newConnection);
    }

    private NewConnectionCallback newConnection = new NewConnectionCallback() {
        @Override
        public void callback(int sockfd, InetSocketAddress peerAddr) {
            EventLoop ioLoop = threadPool.getNextLoop();
            String connName = name + ": " + hostPort + "#" + nextConnId;
            ++nextConnId;
            log.info("TcpServer::newConnection [{}] - new connection [{}] from {}",
                    name, connName, peerAddr.getHostString());
            InetSocketAddress localAddress = new ServerSocket()

        }
    }

    //private NewConnectionCallback newConnection2 = (int sockfd, InetAddress peerAddr) -> {
    //    //EventLoop ioLoop = threadPool.getNextLoop();
    //    //char[] buf = new char[32];
    //    //String s = hostPort+"#"+nextConnId;
    //    //++nextConnId;
    //    //InetAddress localAddress =
    //    //String connName = name + s;
    //    //
    //    //TcpConnectionPtr conn = new TcpConnectionPtr(
    //    //        new TcpConnection(ioLoop, connName, )
    //    //);
    //
    //};


}
