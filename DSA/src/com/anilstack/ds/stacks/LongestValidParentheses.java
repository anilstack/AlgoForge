package com.anilstack.ds.stacks;

import java.util.Stack;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class LongestValidParentheses {
    //need to return longestvalidparentheses substring. () is valid then return 2 is the answer.
//()() is valid cases return 4.
    public static void main(String[] args) {
        String s = "(()";
        String s1 = ")()())";
        System.out.println(LongestValidParentheses.findLongestValidParentheses(s));
    }

    private static int findLongestValidParentheses(String s) {

        if (s.length() < 2 || s.isEmpty()) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {

                //while bracket is closing state
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }

        int maxLen = 0;
        int endTerminal = s.length();

        while (!stack.isEmpty()) {
            int startTerminal = stack.pop();
            maxLen = Math.max(maxLen, endTerminal - startTerminal - 1);
            endTerminal = startTerminal;
        }

        return Math.max(endTerminal, maxLen);
    }
}
