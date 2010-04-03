package com.tdd;

/**
 * User: shiv
 */
public class Franc extends Money {

    public Franc(int i) {
        super(i);
    }

    public Franc times(int multiplier) {
        return new Franc(amount * multiplier);
    }
}