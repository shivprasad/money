package com.tdd;

/**
 * User: shiv
 */
public abstract class Money {
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

    abstract public Money times(int multiplier);

    public static Dollar dollar(int amount) {
        return new Dollar(amount);
    }

    public static Franc franc(int amount) {
        return new Franc(amount);
    }
}
