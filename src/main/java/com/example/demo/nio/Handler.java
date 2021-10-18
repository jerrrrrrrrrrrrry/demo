package com.example.demo.nio;

import com.example.demo.nio.SystemConfig;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class Handler implements Runnable {
    final SocketChannel channel;
    final SelectionKey sk;
    ByteBuffer input = ByteBuffer.allocate(SystemConfig.INPUT_SIZE);
    ByteBuffer output = ByteBuffer.allocate(SystemConfig.SEND_SIZE);
    static final int READING = 0, SENDING = 1;
    int state = READING;

    Handler(Selector selector, SocketChannel c) throws IOException {
        channel = c;
        c.configureBlocking(false);
        selector.wakeup();
        // Optionally try first read now
        sk = channel.register(selector, SelectionKey.OP_READ);

        //将Handler作为callback对象
        sk.attach(this);

        //第二步,注册Read就绪事件
        sk.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    boolean inputIsComplete() {
        /* ... */
        return true;
    }

    boolean outputIsComplete() {

        /* ... */
        return true;
    }

    void process() {
        /* ... */
        return;
    }

    public void run() {
        try {
            if (state == READING) {
                read();
            } else if (state == SENDING) {
                send();
            }
        } catch (IOException ex) { /* ... */ }
    }

    void read() throws IOException {
        int length = 0;
        length = channel.read(input);
        if (inputIsComplete()) {
            System.out.println(new String(input.array(), 0, length));

            process();

            state = SENDING;
            // Normally also do first write now

            //第三步,接收write就绪事件
            sk.interestOps(SelectionKey.OP_WRITE);
        }
    }

    void send() throws IOException {
        channel.write(output);

        //write完就结束了, 关闭select key
        if (outputIsComplete()) {
            sk.cancel();
        }
    }
}
