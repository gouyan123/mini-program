package com.nio;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BlockingNioTest {

    /**
     * 接收客户端的请求保存到本地文件
     * @throws IOException
     */
    @Test
    public void server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9999));

        SocketChannel socketChannel = serverSocketChannel.accept();

        FileChannel outChannel = FileChannel.open(Paths.get("E:/server/transferedFile.txt"),
                StandardOpenOption.READ, StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024*1024);

        while (socketChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            int writeSize = outChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        outChannel.close();
    }


    @Test
    public void client() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
        FileChannel inChannel = new RandomAccessFile("E:/shop_20180228003815.sql", "rw").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024*1024);
        while (inChannel.read(buffer) != -1) {
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }
        socketChannel.close();
        inChannel.close();
    }

}
