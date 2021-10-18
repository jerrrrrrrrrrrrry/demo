package com.example.demo.nio.TCPReactor;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-02-05 14:40
 **/
public interface HandlerState {
    public void changeState(TCPHandler h);

    public void handle(TCPHandler h, SelectionKey sk, SocketChannel sc,
                       ThreadPoolExecutor pool) throws IOException ;
}
