package io.conan.bootstrap;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Ai Lun on 2020-08-10.
 */
public class SocketsOps {

    public static ServerSocket createNonblockingOrDie() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setNonBlockAndCloseOnExec(serverSocket);
        return serverSocket;
    }

    private static ServerSocket setNonBlockAndCloseOnExec(ServerSocket serverSocket) {
        return serverSocket;
    }

    //private static bindOrDie() {
    //
    //}

}
