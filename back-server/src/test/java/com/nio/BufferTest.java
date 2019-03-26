package com.nio;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BufferTest {

    @Test
    public void test1() {
        // 1 开辟一个 1024 字节大小的空间
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        printProperties(buffer);

        // 2 存放数据 （1）直接从通道channel中读取数据 （2）手动存放数
        buffer.put((byte)123);
        printProperties(buffer);

        buffer.putChar('a');
        printProperties(buffer);

        // 3 切换到读模式
        buffer.flip();
        printProperties(buffer);

        // 4 读取内容
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
            printProperties(buffer);
        }
    }


    public void printProperties(Buffer buffer) {
        System.out.println("capacity: " + buffer.capacity());
        System.out.println("limit: " + buffer.limit());
        System.out.println("position: " + buffer.position());
        System.out.println("---------------------------------");
    }


}
