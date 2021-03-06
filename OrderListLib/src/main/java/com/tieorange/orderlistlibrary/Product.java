package com.tieorange.orderlistlibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by tieorange on 15/10/2016.
 */
public class Product implements Cloneable {
    public String name;
    public int price;
    public int cookingTime;
    public String photoUrl;

    public Product(String name, double price, int cookingTime) {
        this.name = name;
        this.price = convertPriceDoubleToInt(price);
        this.cookingTime = cookingTime;
    }

    private static int convertPriceDoubleToInt(double price) {
        return (int) (price * 100);
    }


    public static List<Product> getDummy(int count) {
        List<Product> productList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int cookingTime = random.nextInt(20);
            double price = random.nextDouble() * 20;
            productList.add(new Product("Pierogi", price, cookingTime));
        }
        return productList;
    }


    public String getStringPrice() {
        double priceDouble = price / 100f;
        return String.format("%.2f", priceDouble) + " zł";
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public double getDoublePrice() {
        return price / 100f;
    }

    public static double convertIntToDoublePrice(int result) {
        return result / 100f;
    }
}
