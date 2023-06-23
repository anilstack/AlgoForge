package com.anilstack.ds.stacks;


import java.util.Stack;
/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class DecodeString {

    public static void main(String[] args) {
        String s = "e3[a2[c]]";   //eaccaccacc
        System.out.println(DecodeString.decodeString(s));
    }

    private static String decodeString (String s) {

        Stack<Integer> freqStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();


        StringBuilder currentString = new StringBuilder();
        int digit = 0;

        for (char ch:s.toCharArray()) {
            if (Character.isDigit(ch)) {
                digit = digit * 10 + (ch-'0');
            } else if (Character.isLetter(ch)) {
                currentString.append(ch);
            } else if (ch == '[') {
                freqStack.push(digit);
                strStack.push(currentString);
                digit = 0;
                currentString = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder temp = currentString;
                int freq = freqStack.pop();
                currentString = strStack.pop();
                while (freq-- > 0) {
                    currentString.append(temp);
                }
                digit = 0;
            }
        }

        return currentString.toString();
    }

}
