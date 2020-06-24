package com.akadatsky.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyExchange {

    /**
     * Given a dict of { A->B: 100, A->C: 100, BTC->ETH: 5 }
     *
     * Get maxValue from source Coin --> target coin.
     *
     * Can use DFS / BFS / Dijstra / courseScehdule with cycle
     * */
    Map<String, List<String>> canExchange;
    Map<String, Float> currency;
    float maxProfit;

    public CurrencyExchange(Map<String, Float> currency) {

        this.currency = currency;
        this.canExchange = new HashMap<>();
        this.maxProfit = 0;

        for (String key: currency.keySet()) {

            String[] source_target = key.split("->");
            String source = source_target[0];
            String target = source_target[1];
            List<String> neighborCurrency;

            if (canExchange.containsKey(source)) {
                neighborCurrency = canExchange.get(source);
            } else {
                neighborCurrency = new ArrayList<>();
            }
            neighborCurrency.add(target);
            canExchange.put(source, neighborCurrency);
        }
    }

    public List<List<String>> findAllWays(String source, String target) {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        findNextExchange(source, target, curr, ans);
        return ans;
    }

    public void findNextExchange(String source, String target, List<String> curr, List<List<String>> ans) {
        if (source.equals(target)) {
            curr.add(source);
            ans.add(curr);
            return;
        }

        curr.add(source);
        if (canExchange.containsKey(source)) {
            for (String next: canExchange.get(source)) {
                findNextExchange(next, target, curr, ans);
            }
        }
    }

    /**
     * Find max profit
     * */
    public float findMaxProfits(String source, String target) throws Exception {
        float curProfit = 0;

        findNextProfit(source, target, curProfit);
        return maxProfit;
    }

    public void findNextProfit(String source, String target, float curProfit) throws Exception {
        if (source.equals(target)) {
            this.maxProfit = Math.max(maxProfit, curProfit);
            return;
        }

        if (canExchange.containsKey(source)) {
            for (String next: canExchange.get(source)) {
                StringBuilder sb = new StringBuilder();
                sb.append(source);
                sb.append("->");
                sb.append(next);
                String source_next = sb.toString();

                if (currency.containsKey(source_next)) {
                    float value = currency.get(source_next);
                    curProfit *= value;

                    findNextProfit(next, target, curProfit);
                } else {
                    throw new Exception("invalid");
                }
            }
        }
    }




}
