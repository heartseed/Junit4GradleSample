package com.akadatsky.design;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CurrencyExchangeTest {

    private final Map<String, Float> input = new HashMap<String, Float>() {{
        put("A->B", (float)100);
        put("B->A", (float)0.1);
        put("A->C", (float)2);
        put("B->D", (float)3);
        put("C->D", (float)3);
        put("A->D", (float)1);
    }};
    private final CurrencyExchange currencyEngine = new CurrencyExchange(input);

    @Test
    public void testCurrency() {
        Assert.assertEquals(3, currencyEngine.findAllWays("A", "D").size());
        System.out.println(currencyEngine.findMaxProfits("A", "D"));
        Assert.assertEquals(300, currencyEngine.findMaxProfits("A", "D"), 0.0001);
    }
}
