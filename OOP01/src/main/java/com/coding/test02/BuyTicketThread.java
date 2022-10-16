package com.coding.test02;

/**
 * @Author yaCoding
 * @create 2022-10-14 下午 3:58
 */

public class BuyTicketThread implements Runnable{

    int ticketNum = 10;

    @Override
    public void run() {
        for (int i = 1; i <= 100 ; i++) {
            if(ticketNum > 0){
                System.out.println("我在"+Thread.currentThread().getName()+"买到了北京到哈尔滨的第"
                        + ticketNum-- + "张车票");
            }
        }
    }
}

class Test {
    //这是main方法，程序的入口
    public static void main(String[] args) {
        //定义一个线程对象：
        BuyTicketThread t = new BuyTicketThread();
        //窗口1买票：
        Thread t1 = new Thread(t,"窗口1");
        t1.start();
        //窗口2买票：
        Thread t2 = new Thread(t,"窗口2");
        t2.start();
        //窗口3买票：
        Thread t3 = new Thread(t,"窗口3");
        t3.start();
    }
}
