package com.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class MoneyTest {


    @Test
    public void shouldMultiplyDollars() {
        assertEquals(Money.dollar(10), Money.dollar(5).times(2));
        assertEquals(Money.dollar(15), Money.dollar(5).times(3));
    }

    @Test
    public void shouldMultiplyFranc() {
        assertEquals(Money.franc(10), Money.franc(5).times(2));
        assertEquals(Money.franc(15), Money.franc(5).times(3));
    }

    @Test
    public void shouldTestEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(6).equals(Money.dollar(5)));
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(6).equals(Money.franc(5)));

        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void shouldTestCurrency() {
        assertEquals("USD",Money.dollar(5).currency());
        assertEquals("CHF",Money.franc(5).currency());
    }

    @Test
    public void shouldPerformSimpleAddition() {
        Bank bank=new Bank();
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Money reduced = bank.reduce(sum,"USD");
        assertEquals(Money.dollar(10), reduced);
    }


    

}
