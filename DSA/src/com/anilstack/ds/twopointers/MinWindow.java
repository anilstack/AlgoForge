package com.anilstack.ds.twopointers;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class MinWindow {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = MinWindow.minWindowone(s, t);
        System.out.println("printing final substring  " + result);
    }

    public static String minWindow(String s, String t) {

        int freq[] = new int[128];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0; // To Store Starting Point Of Your Answer String.
        int counter = t.length();


        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (freq[endChar] > 0) {
                counter--;
            }
            freq[endChar]--;
            end++;
            while (counter == 0) {
                if (minLength > end - start) {
                    minLength = end - start;
                    minStart = start;
                }
                System.out.println("printing substring" + s.substring(start, end));
                char startChar = s.charAt(start);
                freq[startChar]++;
                if (freq[startChar] > 0) {
                    counter++;
                }
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }


    public static String minWindowone(String s, String t) {

        int[] freq = new int[128];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }
        //minStart is used for To Store Starting Point Of Your Answer String.
        int start = 0;
        int end = 0;
        int counter = t.length();
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;

        while (end < s.length()) {

            char endChar = s.charAt(end);
            if (freq[endChar] > 0) {
                counter--;
            }
            freq[endChar]--;
            end++;
            while (counter == 0) {
                if (minLength > end - start) {
                    minLength = end - start;
                    minStart = start;
                }

                char startChar = s.charAt(start);
                freq[startChar]++;
                if (freq[startChar] > 0) {
                    counter++;
                }
                start++;
            }
        }


        return minLength == Integer.MIN_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }




}
