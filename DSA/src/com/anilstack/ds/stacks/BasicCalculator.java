package com.anilstack.ds.stacks;

import java.util.Stack;
/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class BasicCalculator {

    public static void main(String[] args) {
        String s = "1+2+(3-78)";
        String s1 = "1+2-(3-78)";
        System.out.println(BasicCalculator.calculator(s1));
    }
//given string contains digits,+,-,(,) empty space. we need to eval the entire expression and return.
    private static int calculator(String s) {
        int sign = 1;
        int currentNo = 0;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                currentNo = s.charAt(i) - '0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    currentNo = currentNo * 10 + s.charAt(i+1)-'0';
                    i++;
                }
                currentNo = currentNo * sign;
                ans += currentNo;
                currentNo = 0;
                sign = 1;
            } else if (s.charAt(i)=='+') {
                sign = 1;
            } else if (s.charAt(i)=='-') {
                sign = -1;
            } else if (s.charAt(i)=='(') {
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            } else if (s.charAt(i)==')') {
                int prevSign = stack.pop();
                ans = prevSign * ans;
                int prevAns = stack.pop();
                ans = ans + prevAns;
            }

        }


        return ans;
    }
}
