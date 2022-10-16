package com.coding.test01;

/**
 * @Author yaCoding
 * @create 2022-10-14 下午 3:36
 */

public class Test {

    public static void main(String[] args) {
        //给main方法这个主线程设置名字：
        //Thread.currentThread()作用获取当前正在执行的线程
        Thread.currentThread().setName("主线程");
        //主线程中也要输出十个数：
        for (int i = 1; i <= 10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"1-------"+i);
        }
        //制造其他线程，要跟主线程争抢资源：
        //具体的线程对象：子线程
        TestThread tt = new TestThread();
        tt.setName("子线程");
        //tt.run();//调用run方法，想要执行线程中的任务 -->这个run方法不能直接调用，直接调用就会被当做一个普通方法
        //想要tt子线程真正起作用比如要启动线程：
        tt.start();//start()是Thread类中的方法
        //主线程中也要输出十个数：
        for (int i = 1; i <= 10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"2-------"+i);
        }
    }
}

class TestThread extends Thread{
    /*
    线程对象就要开始争抢资源了，这个线程要执行的任务到底是啥？这个任务你要放在方法中
    但是这个方法不能是随便写的一个方法，必须是重写Thread类中的run方法
    然后线程的任务/逻辑写在run方法中
     */
    @Override
    public void run() {
        //输出1-10
        for (int i = 1; i <= 10 ; i++) {
            System.out.println(this.getName()+i);
        }
    }
}
