package com.AndySam.Money;

public enum Coins {

    FIVE_PENCE("5p",0.05),
    TEN_PENCE("10p", 0.10),
    TWENTY_PENCE("20p", 0.20),
    FIFTY_PENCE("50p", 0.50),
    ONE_POUND("£1", 1.00),
    TWO_POUND("£2", 2.00),
    ;

    private final String coinType;
    private final double coinValue;

    Coins(String coinType, double coinValue) {
        this.coinType = coinType;
        this.coinValue = coinValue;
    }

    public String getCoinType() {
        return coinType;
    }

    public double getCoinValue(){
        return coinValue;
    }
}





