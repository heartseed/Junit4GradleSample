package com.akadatsky;

import com.akadatsky.design.CurrencyExchange;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Game start: ");
//
//        ConnectedFour engine = new ConnectedFour(8);
//        engine.move(1);
//        engine.move(2);
//        engine.move(1);
//        engine.move(2);
//        engine.move(1);
//        engine.move(2);
//        engine.move(1);
//        engine.move(2);

        Map<String, Float> input = new HashMap<String, Float>() {{
            put("A->B", (float)100);
            put("B->A", (float)0.1);
            put("A->C", (float)2);
            put("B->D", (float)3);
            put("C->D", (float)3);
            put("A->D", (float)1);
        }};
        CurrencyExchange currencyEngine = new CurrencyExchange(input);

        List<List<String>> ans = currencyEngine.findAllWays("A", "D");

        System.out.println(ans.toString());
        System.out.println(currencyEngine.findMaxProfits("A", "D"));

    }

}
