package com.anilstack.ds.twopointers;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "abca";
        Boolean isPalindrome = ValidPalindrome.isPalindrome(s);
        System.out.println(isPalindrome);
    }

    private static Boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return isPalindromeHelper(s, start + 1, end) || isPalindromeHelper(s, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }

    private static Boolean isPalindromeHelper(String s, int start, int end) {

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
