package com.anilstack.ds.stacks;

import com.anilstack.ds.twopointers.RemoveDuplicates;

import java.util.Stack;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        String s = "bcacbe";
        String s1 = "bcace";
        System.out.println(RemoveDuplicateLetters.removeDuplicates(s));
    }
//ouput string contains each char in string must be part of answer.
//freq of each char should be 1
//Lexographically("apple" comes before "banana" because 'a' is less than 'b') smallest string we need to form
    private static String removeDuplicates(String s) {

//        int n = s.length();
//        boolean visited[] = new boolean[26];
//
//        int lastIndexCharOccurs[] = new int[26];
//
//        for (int i = 0; i < n; i++) {
//            lastIndexCharOccurs[s.charAt(i)-'a'] = i;
//        }
//
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = 0; i < n; i++) {
//
//            int ch = s.charAt(i)-'a';
//
//            if (visited[ch]) continue;
//
//            visited[ch] = true;
//
//            while (!stack.isEmpty() && stack.peek() > ch && lastIndexCharOccurs[stack.peek()] > i) {
//                visited[stack.pop()]=false;
//            }
//
//            stack.push(ch);
//        }
//
//        StringBuilder builder = new StringBuilder();
//        while (!stack.isEmpty()) {
//            builder.insert(0,stack.pop());
//        }
//
//        return builder.toString();
        boolean visited[] = new boolean[26];
        int lastSeen[] = new int[26];

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            lastSeen[c-'a'] = i;
        }

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(visited[c-'a']) {
                continue;
            }

            while(!stack.isEmpty() && stack.peek() > c && i< lastSeen[stack.peek()-'a']) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            visited[c-'a'] = true;
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();


    }
}
