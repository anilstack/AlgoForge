package com.anilstack.ds.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class MapSumPair {

    Map<String,Integer> map = null;
    public MapSumPair() {
        map = new HashMap<>();
    }

    public void insert(String key, int value) {
        map.put(key,value);
    }

    public int sum(String prefix) {
        int total = 0;
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                total += entry.getValue();
            }
        }
        return total;
    }

    public static void main(String[] args) {

        MapSumPair mapSumPair = new MapSumPair();
        mapSumPair.insert("hello",4);
        mapSumPair.insert("apple",5);
        mapSumPair.insert("sum",3);
        mapSumPair.insert("ap",2);

        System.out.println(mapSumPair.sum("ap"));


    }




}
