package com.tdd;

import java.util.HashMap;
import java.util.Map;

/**
 * User: shiv
 */
public class Bank {
    private Map<Pair,Integer> rates = new HashMap<Pair, Integer>();

    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    public void addRate(String from, String to, int rate) {
        Pair pair = new Pair(from, to);
        rates.put(pair,rate);
    }

    public int rate(String from, String to) {
        if (from.equals(to)) {
            return 1;
        }
        Pair pair = new Pair(from, to);
        return rates.get(pair);
    }
}
