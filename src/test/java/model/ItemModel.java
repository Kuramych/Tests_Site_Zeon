package model;

public class ItemModel {

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public ItemModel withName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public ItemModel withPrice(double price) {
        this.price = price;
        return this;
    }
}
