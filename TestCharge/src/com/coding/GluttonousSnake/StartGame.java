package com.coding.GluttonousSnake;

/**
 * @Author yaCoding
 * @create 2022-10-16 下午 3:52
 */

import javax.swing.*;
import java.awt.*;

/**
 * 创建一个窗体
 */
public class StartGame {

    public static void main(String[] args) {
        //创建一个窗体
        JFrame jf = new JFrame();
        //给窗体加一个标题
        jf.setTitle("贪吃蛇 小游戏by yacoding");
        //获取屏幕的宽
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        //获取屏幕的高：
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        //设置窗体的位置：
        jf.setBounds((width-800)/2,(height-800)/2,800,800);
        //在关闭窗体的时候 程序也要停止：
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //进行设置，让窗体的大小不可变：
        jf.setResizable(false);
        //创建一个面板：
        GamePanel gp = new GamePanel();
        //将面板放入窗体中：
        jf.add(gp);
        //将窗体展现出来：--->必须放在最后
        jf.setVisible(true);
    }

}
