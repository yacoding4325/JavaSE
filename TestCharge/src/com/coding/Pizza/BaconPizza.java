package com.coding.Pizza;

/**
 * @Author yaCoding
 * @create 2022-10-16 下午 3:20
 */

public class BaconPizza extends Pizza{

    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public BaconPizza(String name, int size, int price, int weight) {
        super(name, size, price);
        this.weight = weight;
    }

    @Override
    public String showPizza() {
        return super.showPizza() + "\n培根的克数是："+weight+"克";
    }
}
