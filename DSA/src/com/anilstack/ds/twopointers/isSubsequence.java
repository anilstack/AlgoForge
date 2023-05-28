package com.anilstack.ds.twopointers;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class isSubsequence {

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        Boolean result = isSubsequence.Subsequence(s, t);
        System.out.println(result);
    }

    private static Boolean Subsequence(String s, String t) {

        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

}
