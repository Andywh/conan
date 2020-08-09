package io.conan.bootstrap;

import io.conan.callback.*;
import io.conan.channel.Acceptor;
import io.conan.channel.EventLoop;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

import static io.conan.bootstrap.TcpConnection.defaultConnectionCallback;

/**
 * Created by Ai Lun on 2020-08-06.
 */
@Slf4j
@Getter
@Setter
public class TcpServer {

    // main eventloop
    private EventLoop loop;

    private String name;

    private InetAddress address;

    private Acceptor acceptor;

    private EventLoopThreadPool threadPool;

    private ConnectionCallback connectionCallback;

    private MessageCallback messageCallback;

    private WriteCompleteCallback writeCompleteCallback;

    private ThreadInitCallback threadInitCallback;

    private int nextConnId;

    private Socket socket;
    
    private int hostPort;

    private AtomicInteger started;

    private NewConnectionCallback newConnection = new NewConnectionCallback() {
        @Override
        public void callback(Socket socket, InetSocketAddress peerAddr) {

            EventLoop ioLoop = threadPool.getNextLoop();
            String connName = name + ": " + hostPort + "#" + nextConnId;
            ++nextConnId;
            log.info("TcpServer::newConnection [{}] - new connection [{}] from {}",
                    name, connName, peerAddr.getPort());
            InetSocketAddress localAddress = new InetSocketAddress(peerAddr.getPort());

            TcpConnection conn = new TcpConnection(ioLoop, connName, socket, localAddress, peerAddr);
            conn.setConnectionCallback(connectionCallback);
            conn.setMessageCallback(messageCallback);
            conn.setWriteCompleteCallback(writeCompleteCallback);
            //conn.setCloseCallback(removeConnection(conn));
            //ioLoop.runInLoop();
            return;
        }
    };

    public TcpServer(EventLoop loop,
                     InetSocketAddress listenAddr,
                     String name, Acceptor acceptor,
                     EventLoopThreadPool threadPool,
                     int nextConnId) {
        this.loop = loop;
        this.hostPort = listenAddr.getPort();
        this.name = name;
        this.acceptor = acceptor;
        this.threadPool = threadPool;
        this.connectionCallback = defaultConnectionCallback;
        this.nextConnId = nextConnId;
        acceptor.setNewConnectionCallback(newConnection);
    }

    public void start() {
        if (started.getAndSet(1) == 0) {
            threadPool.start(threadInitCallback);
        }
    }



    //private CloseCallback removeConnection = new CloseCallback() {
    //
    //    @Override
    //    public void callback(TcpConnection conn) {
    //        loop.runInLoop();
    //
    //    }
    //}

    //private void removeConnectionInLoop() {
    //
    //}

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
