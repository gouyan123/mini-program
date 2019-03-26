package com.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Buffer
 *   ByteBuffer CharBuffer ShortBuffer IntBuffer LongBuffer FloatBuffer DoubleBuffer
 *
 * Channel
 *   FileChannel 读取文件中的数据
 *   DatagramChannel 通过UPD读取网络中的数据
 *   SocketChannel 通过TCP读取网络中的数据
 *   ServerSocketChannel 监听新进来的TCP连接，对每个新进来的连接创建一个SocketChannel
 *
 * Selector
 *
 */
public class Demo02 {

    public static void main(String[] args) throws Exception {
        fileChannel();
    }

    public static void fileChannel() throws Exception {
        RandomAccessFile accessFile = new RandomAccessFile("E:\\sql_bak\\商品数据_20180307100447.sql", "rw");
        FileChannel fileChannel = accessFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        int length;
        while ((length = fileChannel.read(buffer)) != -1) {
            buffer.flip();
            for (int i = 0; buffer.hasRemaining(); i++) {
                System.out.print(buffer.get());
            }
            System.out.println();
            buffer.clear();
        }

        accessFile.close();
    }



}
