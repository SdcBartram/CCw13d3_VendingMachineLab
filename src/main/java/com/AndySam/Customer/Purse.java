package com.AndySam.Customer;

import com.AndySam.Money.Coins;

import java.util.ArrayList;

public class Purse {
    private ArrayList<Coins> purse;
    private double purseTotal;

    public Purse() {
        this.purse = new ArrayList<>();
    }

    public ArrayList<Coins> getPurse() {
        return purse;
    }

    public double getTotalPurseValue(){
        double totalValue = 0.0;
        for(Coins coins : purse){
            totalValue += coins.getCoinValue();
        }
        return totalValue;
    }

    public void addCoinToPurse(Coins coins) {
        this.purse.add(coins);
    }

    public void removeCoinFromPurse(Coins coins){
        this.purse.remove(coins);
    }

    public void addCoinValueToPurseTotal(Coins coins){
       purseTotal += coins.getCoinValue();
    }

    public void removeCoinValueFromPurseTotal(Coins coins){
        purseTotal -= coins.getCoinValue();
    }
}
