package com.lgx.java.test;

import java.math.BigDecimal;

public class TestBigDecimal {
    public static void main(String[] args) {
        BigDecimal taxRate = BigDecimal.valueOf(23);
        System.out.println(taxRate);

        System.out.println(new BigDecimal("100"));

        System.out.println(taxRate.divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP));

        System.out.println(taxRate.divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP).add(new BigDecimal("1")));
    }
}
