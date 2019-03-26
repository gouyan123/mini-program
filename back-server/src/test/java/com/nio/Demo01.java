package com.nio;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class Demo01 {

    public static void main(String[] args) throws IOException {
        System.out.println(System.currentTimeMillis());
        readAndWriteWithBuffer();
        System.out.println(System.currentTimeMillis());
    }

    public static void readAndWrite() throws IOException {
        File file = new File("E:\\sql_bak\\商品数据_20180307100447.sql");
        InputStream is = new FileInputStream(file);
        OutputStream os = new FileOutputStream("E:/a.txt");

        byte[] buffer = new byte[1024 * 1024];
        for (int length; (length = is.read(buffer)) > 0; ) {
            os.write(buffer, 0, length);
            os.flush();
        }

        os.close();
        is.close();
    }

    public static void readAndWriteWithBuffer() throws IOException {
        File file = new File("E:\\sql_bak\\商品数据_20180307100447.sql");
        InputStream is = new FileInputStream(file);
        OutputStream os = new FileOutputStream("E:/a.txt");

        BufferedInputStream bufferedIs = new BufferedInputStream(is);
        BufferedOutputStream bufferedOs = new BufferedOutputStream(os);

        byte[] buffer = new byte[1024 * 1024];
        for (int length; (length = bufferedIs.read(buffer)) > 0; ) {
            bufferedOs.write(buffer, 0, length);
            bufferedOs.flush();
        }

        bufferedIs.close();
        bufferedOs.close();
        os.close();
        is.close();
    }


}
