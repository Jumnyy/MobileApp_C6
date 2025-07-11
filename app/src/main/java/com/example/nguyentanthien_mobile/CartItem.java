package com.example.nguyentanthien_mobile;

public class CartItem {
    private String name;
    private String price;
    private String size;
    private String color;
    private int imageResId;

    public CartItem(String name, String price, String size, String color, int imageResId) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.color = color;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public int getImageResId() {
        return imageResId;
    }

}
