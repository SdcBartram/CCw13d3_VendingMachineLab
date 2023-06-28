package com.AndySam.VendingMachine;

import com.AndySam.Customer.Customer;
import com.AndySam.Customer.Shopping;
import com.AndySam.Money.Coins;
import com.AndySam.Products.Products;

import java.util.ArrayList;

public class Transaction {
    private double currentAmount;
    private ArrayList<Coins> coinReturn;
    private Products products;
    private Till till;
    private Customer customer;
    private Stock stock;
    private ArrayList<Coins> customerCoins;
    private Shopping shopping;
    private String enteredCode;

    public Transaction(double currentAmount, ArrayList<Coins> coinReturn, Products products, Till till, Stock stock, Shopping shopping) {
        this.currentAmount = 0;
        this.coinReturn = new ArrayList<>();
        this.products = products;
        this.till = till;
        this.stock = stock;
        this.shopping = shopping;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public ArrayList<Coins> getCoinReturn() {
        return coinReturn;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public void purchaseProcess(String enteredCode, ArrayList<Coins> customerCoins, Customer customer) {
        Products product = stock.getProductByCode(enteredCode);

        if (product == null) {
            System.out.println("Invalid product code entered.");
            coinReturn.addAll(customerCoins);
            customerCoins.clear();
            return;
        }

        if (!product.getCode().equals(enteredCode)) {
            System.out.println("Product code does not match the selected product.");
            coinReturn.addAll(customerCoins);
            customerCoins.clear();
            return;
        }
        boolean coinMatch = false;
        for (Coins coin : customerCoins) {
            for (Coins validCoin : Coins.values()) {
                if (validCoin.getCoinType().equals(coin.getCoinType())) {
                    coinMatch = true;
                    break;
                }
            }
            if (!coinMatch) {
                setCurrentAmount(0);
                coinReturn.add(coin);
                customerCoins.clear();
                return;
            }
        }

        for (Coins coin : customerCoins) {
            currentAmount += coin.getCoinValue();
        }

        if (currentAmount >= product.getPrice()) {
            for (Coins coin : customerCoins) {
                customer.getPurse().removeCoinFromPurse(coin);
                till.addCoinToTill(coin);
            }
            shopping.addProductToShopping(product);
            stock.removeProductFromStock(product);
            currentAmount -= product.getPrice();
        }
        customerCoins.clear();
    }

}
