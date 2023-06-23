package com.anilstack.ds.stacks;


import com.anilstack.ds.util.Pair;

import java.util.Stack;
/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class RemoveAdjacentDuplicates {

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        System.out.println(RemoveAdjacentDuplicates.deleteDuplicates(s,3));
    }

    private static String deleteDuplicates(String s, int k) {

        Stack<Pair<Character,Integer>> stack = new Stack<>();

        for (char ch:s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().getKey() != ch) {
                stack.push(new Pair<>(ch,1));
            } else {
                //matching case
                Pair<Character,Integer> pair = stack.pop();
                stack.push(new Pair<>(pair.getKey(),pair.getValue()+1));

                if (stack.peek().getValue() == k) {
                    stack.pop();
                }

            }
        }

        String ans = "";
        while (!stack.isEmpty()) {
            Pair<Character,Integer> pair = stack.pop();
            int freq = pair.getValue();
            while (freq-- > 0) {
                ans = pair.getKey() + ans;
            }
        }

        return ans;
    }


}
