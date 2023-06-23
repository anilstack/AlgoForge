package com.anilstack.ds.stacks;

import java.util.Stack;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class RemoveKDigits {
    //after removing k digits from given number it should form a lower number than the current number.
    public static void main(String[] args) {
        String num = "1432219";
        String num1 = "14532219";
        String num3 = "13579";
        int k = 3;
        System.out.println(RemoveKDigits.removeKDigits(num,k));
    }

    public static String removeKDigits(String num, int k) {

        Stack<Character> stack = new Stack<>();
        int i = 0;

        for (; i < num.length() && k > 0; ) {

            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(i));
            i++;
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        ans = ans + num.substring(i, num.length());

        i = 0;
        while (i < ans.length()) {
            if (ans.charAt(i) == '0') {
                i++;
            } else {
                break;
            }
        }

        return ans.substring(i).length() == 0 ? "0" : ans.substring(i);
//        return ans;
    }


}
