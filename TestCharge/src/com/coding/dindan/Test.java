package com.coding.dindan;

import java.util.Scanner;

/**
 * @Author yaCoding
 * @create 2022-10-16 上午 9:38
 */

public class Test {

    public static void main(String[] args) {
        //定义一个字符串，用来接收整个收支明细
        String details = "";
        //定义一个变量，接收余额
        int balance = 0; //初始化金额为0元
        while (true){
            System.out.println("------------------这是一个记账系统-----------------");
            System.out.println("1.收支明细");
            System.out.println("2.登记收入");
            System.out.println("3.登记支出");
            System.out.println("4.退出系统");
            System.out.println("请输入你要选择的功能：");
            System.out.println("------------------这是一个记账系统-----------------");

            //拿来一个扫描器
            Scanner scanner = new Scanner(System.in);
            //接收一个来自键盘录入的int类型的数据：
            int choice = scanner.nextInt();
            //对你要录入的choice 做一个过滤
            while (choice!=1 && choice!=2 && choice!=3 && choice!=4) {
                System.out.println("对不起，你录入的功能错误，请重新录入：");
                int newChoice = scanner.nextInt();
                choice = newChoice;
            }

            //根据你录入的数字，判断执行对应的功能：
            switch (choice) {
                case 1:
                    System.out.println("记账系统》》》》收支明细");
                    //如果直接输出details，那么最后多了一个换行：
                    System.out.println(details);
                    break;
                case 2:
                    System.out.println("记账系统》》》》登记收入");
                    System.out.println("请录入收入金额：");
                    double income = scanner.nextDouble();
                    System.out.println("请录入收入详情：");
                    String incomeDetail = scanner.next();
                    balance += income;
                    details = details+"收入："+income+",收入说明："+incomeDetail+",账户余额："+balance+"\n";
                    break;
                case 3:
                    System.out.println("记账系统》》》》登记支出");
                    System.out.println("请录入支出金额：");
                    double expend = scanner.nextDouble();
                    System.out.println("请录入支出详情：");
                    String expendDetail = scanner.next();
                    balance -= expend;
                    details = details+"支出："+expend+",支出说明："+expendDetail+",账户余额："+balance+"\n";
                    break;
                case 4:
                    System.out.println("记账系统》》》》退出功能");
                    System.out.println("确定要退出吗？Y/N:");
                    String isExit = scanner.next();
                    switch (isExit) {
                        case "Y" :
                            System.out.println("系统退出，欢迎您下次继续使用！");
                            return;//结束当前方法
                    }
            }
        }

    }

}
