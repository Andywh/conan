package test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Ai Lun on 2020-08-06.
 */
public class Server {

    private ServerSocket serverSocket;

    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("服务端启动成功，端口: " + port);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("服务端启动失败");
        }
    }

    public void start() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("服务端异常");
            }
        }
    }

    public static void main(String[] args) {

    }

}
