package com.tdd;

/**
 * User: shiv
 */
public class Franc {
    private int amount;

    public Franc(int i) {
        amount = i;
    }

    public Franc times(int multiplier) {
        return new Franc(amount * multiplier);
    }

    @Override
    public boolean equals(Object obj) {
        return amount == ((Franc) obj).amount;
    }
}