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
        return amount == ((Money) obj).amount;
    }
}
