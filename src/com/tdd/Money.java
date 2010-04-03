package com.tdd;

/**
 * User: shiv
 */
public abstract class Money {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money() {
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass().equals(getClass()) && amount == ((Money) obj).amount;
    }

    abstract public Money times(int multiplier);

    public static Dollar dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Franc franc(int amount) {
        return new Franc(amount, "CHF");
    }

    public String currency() {
        return currency;
    }
}
