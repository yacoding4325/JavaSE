package com.coding.test01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author yaCoding
 * @create 2022-10-14 下午 9:15
 */

public class TestSend {

    //这是一个main方法，是程序的入口：
    public static void main(String[] args) throws IOException {
        System.out.println("学生上线。。。");
        //1.准备套接字： 指定发送方的端口号
        DatagramSocket ds = new DatagramSocket(8888);
        //2.准备数据包
        String str = "你好";
        byte[] bytes = str.getBytes();
        /*
        需要四个参数：
        1.指的是传送数据转为字节数组
        2.字节数组的长度
        3.封装接收方的ip
        4.指定接收方的端口号
         */
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,
                InetAddress.getByName("localhost"),9999);
        //发送：
        ds.send(dp);
        //关闭资源
        ds.close();
    }

}
