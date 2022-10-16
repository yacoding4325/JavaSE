package com.coding.test02;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author yaCoding
 * @create 2022-10-14 下午 4:00
 */

public class TestRandomNum implements Callable<Integer> {

    /*
    1.实现Callable接口，可以不带泛型，如果不带泛型，那么call方式的返回值就是Object类型
    2.如果带泛型，那么call的返回值就是泛型对应的类型
    3.从call方法看到：方法有返回值，可以跑出异常
    */

    @Override
    public Integer call() throws Exception {
        return new Random().nextInt(10);//返回10以内的随机数
    }

}

class Test0 {
    //这是main方法，程序的入口
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //定义一个线程对象：
        TestRandomNum trn = new TestRandomNum();
        FutureTask ft = new FutureTask(trn);
        Thread t = new Thread(ft);
        t.start();
        //获取线程得到的返回值：
        Object obj = ft.get();
        System.out.println(obj);
    }
}
