package com.example.demo.nio;

import lombok.extern.slf4j.Slf4j;
import java.nio.IntBuffer;

/**
 * @program: demo
 * @description: nio-bufferDemo
 * @author: Gu
 * @create: 2021-01-28 13:48
 **/
@Slf4j
public class BufferDemo {
    static IntBuffer byteBuffer = null;

    public static void allocatTest() {
        byteBuffer = IntBuffer.allocate(20);
        log.info("------------after allocate------------------");
        log.info("position=" + byteBuffer.position());
        log.info("limit=" + byteBuffer.limit());
        log.info("capacity=" + byteBuffer.capacity());
    }

    public static void putTest() {
        for (int i = 0; i < 5; i++) {
            byteBuffer.put(i);
        }
        log.info("------------after putTest------------------");
        log.info("position=" + byteBuffer.position());
        log.info("limit=" + byteBuffer.limit());
        log.info("capacity=" + byteBuffer.capacity());
    }

    public static void flipTest() {
        byteBuffer.flip();
        log.info("------------after flipTest ------------------");
        log.info("position=" + byteBuffer.position());
        log.info("limit=" + byteBuffer.limit());
        log.info("capacity=" + byteBuffer.capacity());
    }

    public static void rewindTest() {
        byteBuffer.rewind();
        log.info("------------after flipTest ------------------");
        log.info("position=" + byteBuffer.position());
        log.info("limit=" + byteBuffer.limit());
        log.info("capacity=" + byteBuffer.capacity());
    }

    public static void getTest() {
        log.info("------------after &getTest 2------------------");
        for (int i = 0; i < 2; i++) {
            int j = byteBuffer.get();
            log.info("j = " + j);
        }
        log.info("position=" + byteBuffer.position());
        log.info("limit=" + byteBuffer.limit());
        log.info("capacity=" + byteBuffer.capacity());
        log.info("------------after &getTest 3------------------");
        for (int i = 0; i < 3; i++) {
            int j = byteBuffer.get();
            log.info("j = " + j);
        }
        log.info("position=" + byteBuffer.position());
        log.info("limit=" + byteBuffer.limit());
        log.info("capacity=" + byteBuffer.capacity());
    }

    public static void reRead() {
        log.info("------------after reRead------------------");
        for (int i = 0; i < 5; i++) {
            int j = byteBuffer.get();
            log.info("j = " + j);
            if (i == 2) {
                byteBuffer.mark();
            }
        }
        log.info("position=" + byteBuffer.position());
        log.info("limit=" + byteBuffer.limit());
        log.info("capacity=" + byteBuffer.capacity());
    }

    public static void afterReset() {
        log.info("------------after reset------------------");
        byteBuffer.reset();
        log.info("position=" + byteBuffer.position());
        log.info("limit=" + byteBuffer.limit());
        log.info("capacity=" + byteBuffer.capacity());
    }

    public static void clearDemo() {
        log.info("------------after clear------------------");
        byteBuffer.clear();
        log.info("position=" + byteBuffer.position());
        log.info("limit=" + byteBuffer.limit());
        log.info("capacity=" + byteBuffer.capacity());
    }

    public static void main(String[] args) {
        log.info("分配内存");
        allocatTest();
        log.info("写入");
        putTest();
        log.info("翻转");
        flipTest();
        log.info("读取");
        getTest();
        log.info("重复读");
        rewindTest();
        reRead();
        log.info("make&reset写读");
        afterReset();
        log.info("清空");
        clearDemo();
    }
}
