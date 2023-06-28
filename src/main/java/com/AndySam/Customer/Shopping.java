package com.AndySam.Customer;

import com.AndySam.Products.Products;

import java.util.ArrayList;

public class Shopping {
    private ArrayList<Products> purchases;

    public Shopping() {
        this.purchases = new ArrayList<>();
    }

    public ArrayList<Products> getPurchases() {
        return purchases;
    }

    public void addProductToShopping(Products products){
        this.purchases.add(products);
    }
}
