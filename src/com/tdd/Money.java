package com.tdd;


/**
 * User: shiv
 */
public class Money implements Expression {
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
        return obj.getClass().equals(getClass()) && amount == ((Money) obj).amount && currency.equals(((Money) obj).currency);
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public String currency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Expression plus(Money added) {
        return new Sum(this, added);
    }

    public Money reduce(String to) {
        return this;
    }
}
