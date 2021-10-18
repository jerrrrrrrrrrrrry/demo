package com.example.demo.nio.TCPReactor;

import java.io.IOException;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-02-05 14:42
 **/
public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            TCPReactor reactor = new TCPReactor(1333);
            reactor.run();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
