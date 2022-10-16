package com.coding.doublecolourballs;

import javax.swing.event.MenuKeyListener;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author yaCoding
 * @create 2022-10-16 下午 1:21
 */

public class Test2 {

    public static void main(String[] args) {

        //声明一个数组，用来接收7个球的数字：
        int[] balls = new int[7];
        //购买注数：
        int count = 0;
        while (true) {
            //写菜单
            System.out.println("------欢迎进入双色球彩票系统---------");
            System.out.println("1.购买彩票");
            System.out.println("2.查看开奖");
            System.out.println("3.退出");
            System.out.println("请选择你要完成的功能：");
            System.out.println("------欢迎进入双色球彩票系统---------");
            //拿过来一个扫描器：
            Scanner scanner = new Scanner(System.in);
            //从键盘接收一个int类型的数据
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("双色球系统->>购买彩票");
                    System.out.println("请选择你要购买几注：");
                    count = scanner.nextInt();//购买数量
//                    int[] balls = new int[7];
//                    int count = 0;
                    for(int i=1;i<=7;i++){
                        if(i!=7){//录入红色球
                            System.out.println("请录入第"+i+"个红球：");
                            int redBall = scanner.nextInt();
                            balls[i-1] = redBall;
                        }else{//i==7  录入蓝色球
                            System.out.println("请录入一个蓝色球：");
                            int blueBall = scanner.nextInt();
                            balls[6] = blueBall;
                        }
                    }
                    //提示完整信息：
                    System.out.println("您购买了"+count+"注彩票,一共消费了"+count*2+"元钱,您购买的彩票号码为：");
                    //遍历数组：
                    for(int num:balls){
                        System.out.print(num+"\t");
                    }
                    //换行1
                    System.out.println();
                    break;
                case 2:
                    //1.购买号码-->balls
                    //2.中奖号码
                    int[] luckBall = getLuckBall();
                    //3.将两组号码进行比对
                    int level = getLevel(balls,luckBall);
                    //4.根据level的结果执行后面的逻辑：
                    switch (level){
                        case 1:
                            System.out.println("恭喜你，中了1等奖，1注奖金500万，您一共获得："+500*count+"万元");
                            break;
                        case 2:
                            System.out.println("恭喜你，中了2等奖，1注奖金100万，您一共获得："+100*count+"万元");
                            break;
                        case 3:
                            System.out.println("恭喜你，中了3等奖，1注奖金30万，您一共获得："+30*count+"万元");
                            break;
                        case 4:
                            System.out.println("恭喜你，中了4等奖，1注奖金5万，您一共获得："+5*count+"万元");
                            break;
                        case 5:
                            System.out.println("恭喜你，中了5等奖，1注奖金2000千元，您一共获得："+2000*count+"元");
                            break;
                        case 6:
                            System.out.println("恭喜你，中了6等奖，1注奖金5万，您一共获得："+5*count+"元");
                            break;
                    }
                    System.out.println("双色球系统》》查看开奖");
                    break;
                case 3:
                    System.out.println("双色球系统-->>退出");
                    return;//遇到return结束当前方法
            }
        }
    }

    //定义一个方法，专门用来比对 购买号码和中奖号码的：
    private static int getLevel(int[] balls, int[] luckBall) {
        int level = 1;
        //添加计数器：用来计红球有几个相等的：
        int redCount = 0;
        //添加计数器：用来计蓝球有几个相等的：
        int blueCount = 0;
        //就是将我们的球一个一个的跟中奖号码比对：遍历我购买的号码
        for (int i = 0; i <=6; i++) {
            if (i!=6) {
                for (int j = 0; j <= 5; j++) {
                    if (balls[i] == luckBall[j]) {
                        redCount++;
                    }
                }
            } else  {
                if (balls[6] == luckBall[6]) {
                    blueCount++;
                }
            }
        }
        //输出对比结果
        System.out.println("红球有"+redCount+"个相等");
        System.out.println("蓝球有"+blueCount+"个相等");

        //根据红球和蓝球的相等的数量得到level的具体结果：
        if(redCount==6&&blueCount==1){
            level = 1;
        }else if(redCount==6){
            level = 2;
        }else if(redCount==5&&blueCount==1){
            level = 3;
        }else if(redCount==5||(redCount==4&&blueCount==1)){
            level = 4;
        }else if(redCount==4||(redCount==3&&blueCount==1)){
            level = 5;
        }else{
            level = 6;
        }
        return level;
    }

    //定义一个方法，专门用来生成中奖号码：
    private static int[] getLuckBall() {
//        int[] luckBall = {1,2,3,4,5,6,7};
        int[] luckBall = new int[7];
        /*
        红球：1-33
        篮球：1-16
        1-33
        Math.random() -> [0.0,1.0)
        Math.random()*33 -> [0.0,33.0)
        (int)(Math.random()*33) -> [0,32]
        (int)(Math.random()*33)+1 ->[1,33]
         */
        for (int i = 1; i <= 7; i++) {
            if (i!=7) {//给红球赋值
                luckBall[i-1] = (int) (Math.random()*33) + 1;
            }else {
                luckBall[6] = (int) (Math.random()*16) + 1;
            }
        }
        return luckBall;
    }

}
