package com.tdd;

/**
 * User: shiv
 */
public class Sum implements Expression{
    public Expression augend;
    public Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to) {
        int amount = this.addend.reduce(bank,to).amount + this.augend.reduce(bank,to).amount;
        return new Money(amount, to);
    }

    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier),addend.times(multiplier));
    }

    public Expression plus(Expression added) {
        return new Sum(this,added);
    }
}
