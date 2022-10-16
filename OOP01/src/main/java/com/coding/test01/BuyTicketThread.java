package com.coding.test01;

/**
 * @Author yaCoding
 * @create 2022-10-14 下午 3:42
 */

public class BuyTicketThread extends Thread{

    public BuyTicketThread(String name) {
        super(name);
    }

    //一共10张票：
    static int ticketNum = 10;//多个对象共享10张票
    //每个窗口都是一个线程对象：每个对象执行的代码放入run方法中

    @Override
    public void run() {
        for (int i = 1; i <= 100 ; i++) {
            if(ticketNum > 0){//对票数进行判断，票数大于零我们才抢票
                System.out.println("我在"+this.getName()+"买到了从北京到哈尔滨的第" + ticketNum-- + "张车票");
            }
        }
    }
}

class Test2 {
    public static void main(String[] args) {
        //多个窗口抢票：三个窗口三个线程对象：
        BuyTicketThread t1 = new BuyTicketThread("窗口1");
        t1.start();

        BuyTicketThread t2 = new BuyTicketThread("窗口2");
        t2.start();
//
//        BuyTicketThread t3 = new BuyTicketThread("窗口3");
//        t3.start();
    }
}
