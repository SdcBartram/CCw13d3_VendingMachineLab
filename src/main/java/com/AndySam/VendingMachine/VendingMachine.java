package com.AndySam.VendingMachine;

public class VendingMachine {
    private Stock stock;
    private Till till;

    public VendingMachine(Stock stock, Till till){
        this.stock = stock;
        this.till = till;
    }

    public Stock getStock() {
        return stock;
    }

    public Till getTill() {
        return till;
    }

}
