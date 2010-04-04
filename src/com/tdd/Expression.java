package com.tdd;

/**
 * User: shiv
 */
public interface Expression {
    Money reduce(Bank bank, String to);

    Expression times(int multiplier);

    Expression plus(Expression added);
}
