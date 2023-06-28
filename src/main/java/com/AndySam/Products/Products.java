package com.AndySam.Products;

public class Products {
    private String code;
    private String name;
    private double price;

    public Products(String code, String name, double price ) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
