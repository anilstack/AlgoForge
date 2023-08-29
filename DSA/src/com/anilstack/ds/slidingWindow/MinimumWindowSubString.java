package com.anilstack.ds.slidingWindow;

public class MinimumWindowSubString {
//return the minimumwindow substring of s such that every char in t including duplicates is included in the window.
//a substring is a contiguous sequence of chars within the string.
    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(MinimumWindowSubString.minWindow(s,t));
    }

    private static String minWindow(String s, String t) {

        int[] freq = new int[128];
        for (char c:t.toCharArray()) {
            freq[c]++;
        }

        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();

        while (end < s.length()) {
           char endChar = s.charAt(end);
           if (freq[endChar] > 0) {
               counter--;
           }
           freq[endChar]--;
           end++;

           while (counter == 0) {
               if (minLen > end - start) {
                   minLen = end - start;
                   minStart = start;
               }

               char startingChar = s.charAt(start);
               freq[startingChar]++;
               if (freq[startingChar] > 0) counter++;
               startingChar++;

           }



        }


        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLen);
    }

}
