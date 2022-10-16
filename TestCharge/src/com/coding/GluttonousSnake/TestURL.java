package com.coding.GluttonousSnake;

import java.net.URL;

/**
 * @Author yaCoding
 * @create 2022-10-16 下午 3:47
 */


public class TestURL {

    public static void main(String[] args) {
        //指代的就是相对路径，相对/D:/IDEA_workspace/TestJavaSE/out/production/TestSnakeGame/
        URL url = Images.class.getResource("/");
        System.out.println(url);
    }

}
