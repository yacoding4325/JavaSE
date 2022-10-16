package com.coding.test03;

public class BuyTicketThread extends Thread {
    public BuyTicketThread(String name){
        super(name);
    }

    //一共10张票：
    static int ticketNum = 10;//多个对象共享10张票
    //每个窗口都是一个线程对象：每个对象执行的代码放入run方法中
    @Override
    public void run() {
        //每个窗口后面有100个人在抢票：
        for (int i = 1; i <= 100 ; i++) {
//            buyTicket();
            synchronized (this) {
                if(ticketNum > 0){//对票数进行判断，票数大于零我们才抢票
                    System.out.println("我在"+Thread.currentThread().getName()+
                            "买到了从南京到合肥的第" + ticketNum-- + "张车票");
                }
            }
        }
    }
//    public static synchronized void buyTicket(){//锁住的  同步监视器： BuyTicketThread.class
//        if(ticketNum > 0){//对票数进行判断，票数大于零我们才抢票
//            System.out.println("我在"+Thread.currentThread().getName()+"买到了从北京到哈尔滨的第" + ticketNum-- + "张车票");
//        }
//    }
}

class Test3{
    //这是main方法，程序的入口
    public static void main(String[] args) {
        BuyTicketThread buyTicketThread1 = new BuyTicketThread("窗口1");
        buyTicketThread1.start();

        BuyTicketThread buyTicketThread2 = new BuyTicketThread("窗口2");
        buyTicketThread2.start();

        BuyTicketThread buyTicketThread3 = new BuyTicketThread("窗口3");
        buyTicketThread3.start();
    }
}