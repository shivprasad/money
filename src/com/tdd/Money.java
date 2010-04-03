package com.tdd;

/**
 * User: shiv
 */
public class Money {
    protected int amount;

    public Money(int i) {
        amount = i;
    }

    public Money() {
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass().equals(getClass()) && amount == ((Money) obj).amount;
    }
}
