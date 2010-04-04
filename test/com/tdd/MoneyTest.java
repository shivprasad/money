package com.tdd;

import org.junit.Test;

import static org.junit.Assert.*;


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

    @Test
    public void plusShouldReturnSum() {
        Money five = Money.dollar(5);
        Expression expression = five.plus(five);
        Sum sum= (Sum) expression;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    public void shouldReduceSum() {
        Sum sum = new Sum(Money.dollar(5), Money.dollar(3));
        Bank bank = new Bank();
        Money money = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(8), money);
    }

    @Test
    public void shouldReduceMoneyOfDifferenceCurrencies() {
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1),result);
    }

    @Test
    public void testIdentityRate() throws Exception {
        Bank bank = new Bank();
        assertEquals(1,bank.rate("USD","USD"));
    }

    @Test
    public void shouldAddMixedCurrencies() {
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Money fiveDollars = Money.dollar(5);
        Money tenFrancs = Money.franc(10);
        Money result = bank.reduce(fiveDollars.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10),result);
    }


}
