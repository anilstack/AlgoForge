package com.anilstack.ds.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class FindAllAnagrams {

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        List<Integer> answers = FindAllAnagrams.findAllAnagrams(s, p);
        System.out.println(answers);
    }


    private static List<Integer> findAllAnagrams(String s, String t) {

//        List<Integer> ans = new ArrayList<>();
//
//        int unMatchingCharCount = t.length();
//
//        int[] freqCount = new int[26];
//
//        for (int i = 0; i < t.length(); i++) {
//            int currentCharIndex = t.charAt(i) - 'a';
//            freqCount[currentCharIndex]++;
//        }
//
//        int start = 0;
//        int end = 0;
////for checking upto t's length
//        for (; end < t.length(); end++) {
//            int scharIndex = s.charAt(end) - 'a';
//            if (freqCount[scharIndex] > 0) {
//                unMatchingCharCount--;
//            }
//            freqCount[scharIndex]--;
//        }
//
//        if (unMatchingCharCount == 0) {
//            ans.add(start);
//        }
//
//        for (; end < s.length(); ) {
//            //for moving start index
//            int indexStart = s.charAt(start) - 'a';
//
//            if (freqCount[indexStart] > 0) {
//                unMatchingCharCount++;
//            }
//            freqCount[indexStart]++;
//            start++;
//
//            int indexEnd = s.charAt(end) - 'a';
//
//            if (freqCount[indexEnd] > 0) {
//                unMatchingCharCount--;
//            }
//            freqCount[indexEnd]--;
//
//            end++;
//
//            if (unMatchingCharCount == 0) {
//                ans.add(start);
//            }
//        }
//
//        return ans;
//    }
        List<Integer> ans = new ArrayList<>();

        int unmatchingCharCount = t.length();

        if (t.length() > s.length()) {
            return ans;
        }

        int[] freqCount = new int[26];

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            freqCount[index]++;
        }

        int start = 0;
        int end = 0;
        for (; end < t.length(); end++) {
            int index = s.charAt(end) - 'a';
            if (freqCount[index] > 0) {

                unmatchingCharCount--;
            }
            freqCount[index]--;

        }
        if (unmatchingCharCount == 0) {
            ans.add(start);

        }
        for (; end < s.length(); ) {
            // remove starting index
            int indexStart = s.charAt(start) - 'a';

            if (freqCount[indexStart] >= 0) {
                // char was present in t
                unmatchingCharCount++;
            }

            freqCount[indexStart]++;

            start++;

            int indexEnd = s.charAt(end) - 'a';
            if (freqCount[indexEnd] > 0) {
                unmatchingCharCount--;
            }
            freqCount[indexEnd]--;

            end++;

            if (unmatchingCharCount == 0) {
                ans.add(start);
            }

        }

        return ans;
    }

}
