package com.akadatsky.design;

import java.util.*;

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
        ArrayList<String> curr = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();

        findNextExchange(source, target, curr, ans, visited);
        return ans;
    }

    public void findNextExchange(String source, String target, ArrayList<String> curr, List<List<String>> ans, HashSet<String> visited) {
        if (source.equals(target)) {
            curr.add(source);
            ans.add(curr);
            return;
        }

        curr.add(source);
        visited.add(source);
        if (canExchange.containsKey(source)) {
            for (String next: canExchange.get(source)) {
                System.out.println(source + " " + target + ":" + visited.toString());
                if (!visited.contains(next)) {
                    findNextExchange(next, target, (ArrayList<String>) curr.clone(), ans, (HashSet<String>) visited.clone());
                }
            }
        }
    }

    /**
     * Find max profit
     * */
    public float findMaxProfits(String source, String target) {
        float curProfit = 1;
        HashSet<String> visited = new HashSet<>();

        findNextProfit(source, target, curProfit, visited);
        return maxProfit;
    }

    public void findNextProfit(String source, String target, float curProfit, HashSet<String> visited) {
        if (source.equals(target)) {
            this.maxProfit = Math.max(maxProfit, curProfit);
            return;
        }

        visited.add(source);
        if (canExchange.containsKey(source)) {
            for (String next: canExchange.get(source)) {
                StringBuilder sb = new StringBuilder();
                sb.append(source);
                sb.append("->");
                sb.append(next);
                String source_next = sb.toString();

                if (currency.containsKey(source_next)) {
                    float value = currency.get(source_next);
                    float temp = curProfit * value;
                    System.out.println(temp + "," + source_next);

                    if (!visited.contains(next)) {
                        findNextProfit(next, target, temp, (HashSet<String>) visited.clone());
                    }

                }
            }
        }
    }
}
