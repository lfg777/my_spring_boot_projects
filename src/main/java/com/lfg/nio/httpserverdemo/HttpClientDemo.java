package com.lfg.nio.httpserverdemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * nio简单聊天室客户端
 * @author fg.Li
 * 2019/4/28:13:39
 * <p>
 **/
public class HttpClientDemo {

    public void start() throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost",90));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入：");
            String msg = scanner.nextLine();
            if ("bye".equals(msg)) {
                System.out.println("bye bye");
                break;
            }
            HttpServerDemo.sendMsg(sc, msg);

            String receiveMsg = HttpServerDemo.receiveMsg(sc);
            System.out.println("服务端消息："+receiveMsg);
        }
        sc.close();


    }

    public static void main(String[] args) {
        HttpClientDemo cd = new HttpClientDemo();
        try {
            cd.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
