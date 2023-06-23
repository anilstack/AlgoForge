package com.anilstack.ds.stacks;


import java.util.Stack;
/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class BasicCalculatorTwo {

    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(BasicCalculatorTwo.calculate(s));
    }

    private static int calculate (String s) {

        Stack<Integer> stack = new Stack<>();
        char prevSign = '+';
        int currentNo = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currentNo = currentNo * 10 + (ch - '0');
            }

            if (isOperator(ch) || i == s.length() - 1) {
                if (prevSign == '+') {
                    stack.push(currentNo);
                } else if (prevSign == '-') {
                    stack.push(currentNo);
                } else if (prevSign == '*') {
                    int topElement = stack.pop();
                    stack.push(topElement*currentNo);
                } else if (prevSign == '/') {
                    int topElement = stack.pop();
                    stack.push(topElement/currentNo);
                }
                currentNo = 0;
                prevSign = ch;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

}
