package ru.netology.product;

public class SmartPhone extends Product {
    private String developer;

    public SmartPhone(int id, String name, int price, String developer) {
        super(id, name, price);
        this.developer = developer;
    }
}
