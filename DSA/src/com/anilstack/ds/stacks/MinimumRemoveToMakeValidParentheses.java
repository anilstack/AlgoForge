package com.anilstack.ds.stacks;


import com.anilstack.ds.util.Pair;

import java.util.*;
/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class MinimumRemoveToMakeValidParentheses {

    public static void main(String[] args) {

        String s = "lee(t(c)o)de)";
        String s1 = "a)b(c)d";
        System.out.println(MinimumRemoveToMakeValidParentheses.minRemoveToMakeValid(s1));

    }

    private static String minRemoveToMakeValid(String s) {

        Stack<Pair<Character,Integer>> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
          char ch = s.charAt(i);
          if (ch == ')' || ch == '(') {
              if (stack.isEmpty()) {
                  stack.push(new Pair<>(ch,i));
              } else {
                if (ch == ')' && stack.peek().getKey().equals('(')) {
                  stack.pop();
                }else {
                    stack.push(new Pair<>(ch,i));
                }
              }
          }
        }

        Set<Integer> indexsToBeRemoved = new HashSet<>();
        while (!stack.isEmpty()) {
            indexsToBeRemoved.add(stack.peek().getValue());
            stack.pop();
        }

        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (!indexsToBeRemoved.contains(i)) {
                ans += s.charAt(i);
            }
        }

        return ans;
    }


}
