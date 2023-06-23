package com.anilstack.ds.stacks;


import java.util.Stack;
/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ScoreOfParentheses {

    //() has score 1.
    //AB has score A + B, where A and B are balanced parentheses strings.ex: where A = (), B = () 1 + 1 = 2.
    //(A) has score 2 * A, where A is a balanced parentheses string.where A = (), then 1. 2 * 1 = 2
    //((())) for last case, (()) inner brackets value () = 1 then (1) then 2 * 1 = 2.
    //then the equation will become like this (2) then value for this is 2 * 2 = 4.
    public static void main(String[] args) {
        String s = "(())";
        String s1 = "(()(()))";
        System.out.println(ScoreOfParentheses.calculateScoreTest(s1));
    }

    private static int calculateScoreTest(String s) {

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c+"");
            } else {
                if (c==')') {
                    int innerScore = 0;
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        innerScore += Integer.valueOf(stack.peek());
                        stack.pop();
                    }
                    stack.pop();
                    if (innerScore == 0) {
                        stack.push(1+"");
                    } else {
                        stack.push(2*innerScore+"");
                    }
                } else {
                    //if it is (
                    stack.push(c+"");
                }
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += Integer.valueOf(stack.peek());
            stack.pop();
        }

        return result;
    }








    private static int calculateScore(String s) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c+"");
            } else {
                if (c == ')') {
                    int innerScore = 0;
                    while (!stack.isEmpty() && !stack.peek().equalsIgnoreCase("(")) {
                      //  System.out.println(stack.peek());
                        innerScore += Integer.valueOf(stack.peek());
                        stack.pop();
                    }
                    stack.pop();

                    if (innerScore == 0) {
                        //()
                        stack.push("1");
                    } else {
                        stack.push(2*innerScore+"");
                    }

                } else {
                    stack.push(c+"");
                }
            }
        }

        int score = 0;
        while (!stack.isEmpty()) {
            score += Integer.valueOf(stack.peek());
            stack.pop();
        }

        return score;
    }


}
