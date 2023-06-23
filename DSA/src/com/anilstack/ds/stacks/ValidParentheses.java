package com.anilstack.ds.stacks;


import java.util.Stack;
/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ValidParentheses {

    public static void main(String[] args) {

        String s = "(){}[]";
        System.out.println(ValidParentheses.isValid(s));
    }

    private static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                char topElement = stack.peek();
                if (topElement == '(' && ch == ')') {
                    stack.pop();
                } else if (topElement == '{' && ch == '}') {
                    stack.pop();
                } else if (topElement == '[' && ch ==']') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.isEmpty();
    }
}
