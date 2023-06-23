package com.anilstack.ds.stacks;


import java.util.Stack;
/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ValidateStackSequences {

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {5,4,3,2,1};
        System.out.println(ValidateStackSequences.isValidSequences(pushed,popped));
    }

    private static boolean isValidSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int s = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && popped[s] == stack.peek()) {
                stack.pop();
                s++;
            }

        }
        return stack.isEmpty();
    }
}
