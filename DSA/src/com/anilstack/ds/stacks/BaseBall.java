package com.anilstack.ds.stacks;


import java.util.Stack;
/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class BaseBall {
//you given a string[] which contains four values
//integer value record it to score board
//+ : take the previous two values add them together and create a new score
//D : take previous value double it and add to score board
//C : take previous value and removing it from the score board
// return sum of score board.
    public static void main(String[] args) {

        String[] operations = {"5","2","C","D","+"};
        System.out.println(BaseBall.calculateScoreBoard(operations));

    }

    private static int calculateScoreBoard(String[] operations) {

        Integer topElement = null;
        Integer secondTopElement = null;
        Stack<Integer> stack = new Stack<>();

        for (String operation : operations) {
            char ch = operation.toCharArray()[0];
            switch (ch) {
                case 'C' : stack.pop();
                           break;
                case 'D' : topElement = stack.peek();
                           stack.push(2*topElement);
                           break;
                case '+' : topElement = stack.pop();
                           secondTopElement = stack.peek();
                           stack.push(topElement);
                           stack.push(topElement+secondTopElement);
                           break;
                default: stack.push(Integer.parseInt(operation));
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans = ans + stack.pop();
        }

        return ans;
    }
}
