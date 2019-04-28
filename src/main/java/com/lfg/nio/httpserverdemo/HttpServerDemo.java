package com.lfg.nio.httpserverdemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * nio简单聊天室服务端
 * @author fg.Li
 * 2019/4/28:11:27
 * <p>
 **/
public class HttpServerDemo {

    private int port;

    public HttpServerDemo(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        HttpServerDemo demo = new HttpServerDemo(90);
        try {
            demo.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException {

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(port));
        System.out.println("服务端已启动，正在监听" + port + "端口");
        SocketChannel channel = ssc.accept();
        System.out.println("接收来自"+channel.getRemoteAddress()+"的信息");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String msg = receiveMsg(channel);
            System.out.println("客户端消息："+msg);
            System.out.println("请输入：");
            msg = scanner.nextLine();
            if ("bye".equals(msg)) {
                System.out.println("bye bye");
                sendMsg(channel,msg);
                break;
            }
            sendMsg(channel,msg);
        }

        channel.close();
        ssc.close();

    }

    public static void sendMsg(SocketChannel channel,String in) throws IOException {
        ByteBuffer bf = ByteBuffer.allocate(512);
        bf.clear();
        bf.put(in.getBytes());
        bf.flip();
        channel.write(bf);
    }

    public static String receiveMsg(SocketChannel channel) throws IOException {
        ByteBuffer bf = ByteBuffer.allocate(512);
        bf.clear();
        channel.read(bf);
        bf.flip();
        byte[] bytes = new byte[bf.limit()];
        bf.get(bytes);
        return new String(bytes);
    }


}
