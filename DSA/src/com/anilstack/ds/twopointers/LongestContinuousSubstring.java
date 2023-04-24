package com.anilstack.ds.twopointers;

public class LongestContinuousSubstring {

    public static void main(String[] args) {
            String s = "abacabcda";
            int length = LongestContinuousSubstring.findLongestContinuousSubstring(s);
            System.out.println(length);
    }
//TC: O(n)
//SC: O(1)
    private static int findLongestContinuousSubstring(String s) {

        int start = 0;
        int i = 0;
        int maxLen = 0;
        int currLen = 0;
        int length = s.length();
        while (i < length) {
            while ((i+1 < length) && ((int) (s.charAt(i)) + 1 == (int) (s.charAt(i+1)))) {
                i++;
            }
            currLen = i - start + 1;
            maxLen = Math.max(currLen,maxLen);
            i++;
            start = i;
        }
        return maxLen;
    }
}
