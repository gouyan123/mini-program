package com.nio;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ChannelTest {


    /**
     * NIO 复制数据
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        long startTime = System.currentTimeMillis();
//        FileInputStream is = new FileInputStream("E:/shop_20180228003815.sql");
//        FileOutputStream os = new FileOutputStream("E:/shop_bak.sql");
//
//        ByteChannel inChannel = is.getChannel();
//        ByteChannel outChannel = os.getChannel();

        ByteChannel inChannel = new RandomAccessFile("E:/shop_20180228003815.sql", "rw").getChannel();
        ByteChannel outChannel = new RandomAccessFile("E:/shop_bak.sql", "rw").getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024*1024);
        while (inChannel.read(buffer) != -1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
        System.out.println("cost: " + (System.currentTimeMillis() - startTime));
    }


    /**
     * 传统IO复制文件
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        long startTime = System.currentTimeMillis();
        FileInputStream in = new FileInputStream("E:/shop_20180228003815.sql");
        FileOutputStream out = new FileOutputStream("E:/shop_bak.sql");

        BufferedInputStream bufferedIn = new BufferedInputStream(in);
        BufferedOutputStream bufferedOut = new BufferedOutputStream(out);

        byte[] buffer = new byte[1024*1024];
        int length;
        while ((length = bufferedIn.read(buffer)) != -1) {
            bufferedOut.write(buffer, 0, length);
        }
        bufferedOut.flush();

        System.out.println("cost: " + (System.currentTimeMillis() - startTime));
    }


    /**
     * 利用 Files.copy()
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        long startTime = System.currentTimeMillis();
        Path sourcePath = Paths.get("E:/shop_20180228003815.sql");
        Path targetPath = Paths.get("E:/shop_bak.sql");
        Files.copy(sourcePath, targetPath);
        System.out.println("cost: " + (System.currentTimeMillis() - startTime));
    }


    /**
     * 利用直接通道复制数据
     */
    @Test
    public void tes4() throws IOException {
        long startTime = System.currentTimeMillis();

        FileChannel inChannel = FileChannel.open(Paths.get("E:/shop_20180228003815.sql"),
                StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("E:/shop_bak.sql"),
                StandardOpenOption.WRITE,
                StandardOpenOption.READ,
                StandardOpenOption.CREATE);

        System.out.println(inChannel.size());
        System.out.println(outChannel.size());

        // TODO java.lang.IllegalArgumentException: Size exceeds Integer.MAX_VALUE
        MappedByteBuffer inBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, outChannel.size());

        byte[] dst = new byte[inBuffer.limit()];
        inBuffer.get(dst);
        outBuffer.put(dst);

        System.out.println("cost: " + (System.currentTimeMillis() - startTime));
    }


    /**
     * 通道间的直接传输
     */
    @Test
    public void test5() throws IOException {
        long startTime = System.currentTimeMillis();

        FileChannel inChannel = FileChannel.open(Paths.get("E:/shop_20180228003815.sql"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("E:/shop_bak.sql"),
                StandardOpenOption.READ,
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);
        outChannel.transferFrom(inChannel, 0, inChannel.size());
//        inChannel.transferTo(0, inChannel.size(), outChannel);

        outChannel.close();
        inChannel.close();

        System.out.println("cost: " + (System.currentTimeMillis() - startTime));
    }

}
