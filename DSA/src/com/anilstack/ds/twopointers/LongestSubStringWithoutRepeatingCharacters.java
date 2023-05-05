package com.anilstack.ds.twopointers;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */

public class LongestSubStringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int len = LongestSubStringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
        System.out.println(len);
    }

//TC: O(n)
//SC: O(1)
    public static int lengthOfLongestSubstring(String s) {

        int start = 0;
        int i = 0;
        int maxLen = 0;
        int [] freq = new int[256];

        while (i < s.length()) {
            int iIndex = s.charAt(i);
            freq[iIndex]++;

            while (freq[iIndex] > 1) {
                int sIndex = s.charAt(start);
                freq[sIndex]--;
                start++;
            }

            int currLen = i - start + 1;
            maxLen = Math.max(currLen, maxLen);
            i++;
        }
            return maxLen;
    }
}
