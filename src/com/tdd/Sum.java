package com.tdd;

/**
 * User: shiv
 */
public class Sum implements Expression{
    public Money augend;
    public Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(String to) {
        int amount = this.addend.amount + this.augend.amount;
        return new Money(amount, to);
    }
}
