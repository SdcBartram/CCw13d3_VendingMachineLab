package com.AndySam.VendingMachine;

import com.AndySam.Products.Products;

import java.util.ArrayList;

public class Stock {
    private ArrayList<Products> stock;
    private Products product;

    public Stock() {
        this.stock = new ArrayList<>();
    }

    public ArrayList<Products> getStock() {
        return stock;
    }

    public void addProductToStock (Products products){
        this.stock.add(products);
    }

    public void removeProductFromStock (Products products){
        this.stock.remove(products);
    }

    public Products getProductByCode(String code) {
        for (Products product : stock) {
            if (product.getCode().equals(code)) {
                return product;
            }
        }
        return null;
    }
}
