package com.coding.test01;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author yaCoding
 * @create 2022-10-14 下午 9:04
 */

public class TestClient {

    public static void main(String[] args) throws IOException {

        //1.创建套接字：指定服务器的ip和端口号：
        Socket s = new Socket("192.168.199.217",8888);
        //2.对于程序员来说，向外发送数据 感受 --> 利用输出流：
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        //利用这个OutputStream就可以向外发送数据了，但是没有直接发送String的方法
        //所以我们又在OutputStream外面套了一个处理流：DataOutputStream
        dos.writeUTF("你好");
        //3.关闭流  +  关闭网络资源：
        dos.close();
        os.close();
        s.close();
    }

}
