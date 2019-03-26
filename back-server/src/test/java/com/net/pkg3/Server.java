package com.net.pkg3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        while (true) {
            Socket socket = serverSocket.accept();

            //接收客户端的消息
            InputStream inputStream = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            System.out.println(socket.getRemoteSocketAddress() + " : " + bufferedReader.readLine());

            //服务端发送消息至客户端
            OutputStream os = socket.getOutputStream();
            PrintStream printStream = new PrintStream(os);
            printStream.println("发自服务器的消息：" + System.currentTimeMillis());
            printStream.close();
            os.close();
        }
    }

}
