package com.coding.Pizza;

import java.util.Scanner;

/**
 * @Author yaCoding
 * @create 2022-10-16 下午 3:25
 */

public class Test {

    public static void main(String[] args) {
        //
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择你想要购买的匹萨（1.培根匹萨 2.水果匹萨）:");
        int choice = scanner.nextInt();
        Pizza pizza = PizzaStore.getPizza(choice);
        System.out.println(pizza.showPizza());
    }

}
