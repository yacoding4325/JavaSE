package com.coding.Pizza;

/**
 * @Author yaCoding
 * @create 2022-10-16 下午 3:22
 */

public class FruitsPizza extends Pizza{

    private String burdening;

    public String getBurdening() {
        return burdening;
    }

    public void setBurdening(String burdening) {
        this.burdening = burdening;
    }


    public FruitsPizza(String name, int size, int price, String burdening) {
        super(name, size, price);
        this.burdening = burdening;
    }

    @Override
    public String showPizza() {
        return super.showPizza() + "\n你要加入的水果：" + burdening;
    }

}
