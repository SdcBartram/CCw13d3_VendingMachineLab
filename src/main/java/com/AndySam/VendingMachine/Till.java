package com.AndySam.VendingMachine;

import com.AndySam.Money.Coins;

import java.util.ArrayList;

public class Till {
    private ArrayList<Coins> till;
    private double tillTotal;

    public Till() {
        this.till = new ArrayList<>();
    }

    public ArrayList<Coins> getTill() {
        return till;
    }

    public double getTotalTillValue(){
        double totalValue = 0.0;
        for(Coins coins : till){
            totalValue += coins.getCoinValue();
        }
        return totalValue;
    }

    public void addCoinToTill(Coins coins) {
        this.till.add(coins);
    }

    public void removeCoinFromTill(Coins coins){
        this.till.remove(coins);
    }

    public void addCoinValueToTillTotal(Coins coins){
        tillTotal += coins.getCoinValue();
    }

    public void removeCoinValueFromTillTotal(Coins coins){
        tillTotal -= coins.getCoinValue();
    }
}
