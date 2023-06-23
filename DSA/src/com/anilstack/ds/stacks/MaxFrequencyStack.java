package com.anilstack.ds.stacks;

import java.util.*;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class MaxFrequencyStack {

    List<Stack<Integer>> stackList = null;
    Map<Integer,Integer> map = null;

    public MaxFrequencyStack() {
        stackList = new ArrayList<>();
        map = new HashMap<>();
    }

    public void push(int x) {

        map.put(x,map.getOrDefault(x,0)+1);
        int freq = map.get(x);
        if (freq - 1 >= stackList.size()) {
            stackList.add(new Stack<Integer>());
        }
        stackList.get(freq-1).add(x);
    }

    public int pop() {

        int size = stackList.size();
        int topElement = stackList.get(size-1).pop();
        if (stackList.get(size-1).empty()) stackList.remove(size-1);

        map.put(topElement,map.get(topElement)-1);

        if (map.get(topElement)==0) map.remove(topElement);

        return topElement;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> nestedList = new ArrayList<>();

        nestedList.add(new ArrayList<>());
        nestedList.add(new ArrayList<>(List.of(5)));
        nestedList.add(new ArrayList<>(List.of(7)));
        nestedList.add(new ArrayList<>(List.of(5)));
        nestedList.add(new ArrayList<>(List.of(7)));
        nestedList.add(new ArrayList<>(List.of(4)));
        nestedList.add(new ArrayList<>(List.of(5)));
        nestedList.add(new ArrayList<>());
        nestedList.add(new ArrayList<>());
        nestedList.add(new ArrayList<>());
        nestedList.add(new ArrayList<>());


    }
}
