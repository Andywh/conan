package io.conan.channel;

import io.conan.bootstrap.SocketsOps;
import io.conan.callback.NewConnectionCallback;
import io.conan.callback.ReadEventCallback;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by Ai Lun on 2020-08-06.
 */
@Getter
@Setter
public class Acceptor {

    private EventLoop loop;

    private ServerSocket acceptSocket;

    private Channel acceptChannel;

    private boolean listenning;

    private NewConnectionCallback newConnectionCallback;

    public NewConnectionCallback getNewConnectionCallback() {
        return newConnectionCallback;
    }

    public void setNewConnectionCallback(NewConnectionCallback newConnectionCallback) {
        this.newConnectionCallback = newConnectionCallback;
    }

    public Acceptor(EventLoop loop, SocketAddress socketAddress,
                    Channel acceptChannel, boolean listenning) {
        this.loop = loop;
        this.acceptSocket = SocketsOps.createNonblockingOrDie();
        this.acceptChannel = acceptChannel;
        this.listenning = listenning;
        try {
            this.acceptSocket.bind(socketAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
        acceptChannel.setReadCallback(handleRead);

    }

    private ReadEventCallback handleRead = new ReadEventCallback() {
        @Override
        public void cb() {
            Socket client = null;
            try {
                client = acceptSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (newConnectionCallback != null) {
                newConnectionCallback.callback(client, new InetSocketAddress(client.getPort()));
            } else {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };
}
