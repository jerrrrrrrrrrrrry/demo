package com.example.demo.nio;

import com.example.demo.nio.SubReactor.TCPSubReactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-02-03 16:36
 **/
class MthreadReactor implements Runnable {

    //subReactors集合, 一个selector代表一个subReactor
    Selector[] selectors = new Selector[9];
    ExecutorService pool = Executors.newFixedThreadPool(8);

    int next = 1;
    final ServerSocketChannel serverSocket;

    MthreadReactor(int port) throws IOException { //Reactor初始化
        for (int i=0;i<selectors.length;i++){
            selectors[i] = Selector.open();
        }
        serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(port));
        //非阻塞
        serverSocket.configureBlocking(false);


        //分步处理,第一步,接收accept事件
        SelectionKey sk =
                serverSocket.register(selectors[0], SelectionKey.OP_ACCEPT);
//        SelectionKey sk2 =
//                serverSocket.register( selectors[1], SelectionKey.OP_READ);
        //attach callback object, Acceptor
        sk.attach(new Acceptor());
//        for (int i = 0; i <2 ; i++) {
//            pool.execute(new Processer(i));
//        }

    }

    public void run() {
        for (int i = 0; i < selectors.length; i++) {
            Selector selector = selectors[i];
            pool.execute(
                    () -> {
                        while (!Thread.interrupted()) {
                            try {
                                selector.select();
                                Set selected = selector.selectedKeys();
                                Iterator it = selected.iterator();
                                while (it.hasNext()) {
                                    //Reactor负责dispatch收到的事件
                                    dispatch((SelectionKey) (it.next()));
                                }
                                selected.clear();
                            } catch (Exception e) {

                            }
                        }
                    }
            );

        }


    }

    void dispatch(SelectionKey k) {
        Runnable r = (Runnable) (k.attachment());
        //调用之前注册的callback对象
        if (r != null) {
            r.run();
        }
    }


    class Acceptor implements Runnable { // ...
//        private final ServerSocketChannel ssc; // mainReactor監聽的socket通道
//        private final int cores = Runtime.getRuntime().availableProcessors(); // 取得CPU核心數
//        private final Selector[] selectors = new Selector[cores]; // 創建核心數個selector給subReactor用
//        private int selIdx = 0; // 當前可使用的subReactor索引
//        private TCPSubReactor[] r = new TCPSubReactor[cores]; // subReactor線程
//        private Thread[] t = new Thread[cores]; // subReactor線程
//
//        public Acceptor(ServerSocketChannel ssc) throws IOException {
//            this.ssc = ssc;
//            // 創建多個selector以及多個subReactor線程
//            for (int i = 0; i < cores; i++) {
//                selectors[i] = Selector.open();
//                r[i] = new TCPSubReactor(selectors[i], ssc, i);
//                t[i] = new Thread(r[i]);
//                t[i].start();
//            }
//        }

        public synchronized void run() {
            try {
                SocketChannel connection =
                        serverSocket.accept(); //主selector负责accept
                if (connection != null) {
                    System.out.println("当前subselector："+next);
                    new MthreadHandler(selectors[next], connection); //选个subReactor去负责接收到的connection
                }
                if (++next == selectors.length) {
                    next = 1;
                }
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {
        try {
            MthreadReactor reactor = new MthreadReactor(1333);
            Thread thread = new Thread(reactor);
            thread.start();
        } catch (Exception e) {

        }

    }

//    class Processer implements Runnable {
//        SelectionKey sk;
//
//        Processer(int i) throws ClosedChannelException {
//            sk = serverSocket.register(selectors[i], SelectionKey.OP_ACCEPT);
//        }
//
//        public void run() {
//            sk.attach(new Acceptor());
//        }
//    }
}
