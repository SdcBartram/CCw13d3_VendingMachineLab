package com.AndySam.Customer;


public class Customer {
    private String name;
    private  Purse purse;
    private Shopping shopping;

    public Customer(String name, Purse purse, Shopping shopping) {
        this.name = name;
        this.purse = purse;
        this.shopping = shopping;
    }

    public String getName() {
        return name;
    }

    public Purse getPurse() {
        return purse;
    }

    public Shopping getShopping() {
        return shopping;
    }

}
