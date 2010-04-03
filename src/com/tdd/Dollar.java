package com.tdd;

/**
 * User: shiv
 */
public class Dollar extends Money {

    public Dollar(int i) {
        super(i);
    }

    public Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

}
