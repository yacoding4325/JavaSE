package com.coding.test02;

/**
 * @Author yaCoding
 * @create 2022-10-14 下午 4:29
 */

public class TestThread extends Thread{

    public TestThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10 ; i++) {
            System.out.println(this.getName()+"----"+i);
        }
    }

}

class Test3{
    //这是main方法，程序的入口
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10 ; i++) {
            System.out.println("main-----"+i);
            if(i == 6){
                //创建子线程：
                TestThread tt = new TestThread("创建子线程");
                tt.start();
                tt.join();
            }
        }
    }

}
