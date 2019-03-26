package com.net.pkg3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 3000);

        //客户端发送信息到服务端
        OutputStream os = socket.getOutputStream();
        PrintStream printStream = new PrintStream(os);
        printStream.println(new Scanner(System.in).nextLine());

        //接收服务端发送信息
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println(bufferedReader.readLine());

        printStream.close();
        os.close();
        bufferedReader.close();
        inputStreamReader.close();
    }

}
