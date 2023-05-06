package com.anilstack.ds.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class RemoveAnagrams {

    public static void main(String[] args) {
        String[] words = {"abba", "baba", "bbaa", "cd", "de", "ef"};
        List<String> stringList = RemoveAnagrams.removeAnagrams(words);
        System.out.println(stringList);
    }

    private static List<String> removeAnagrams(String[] words) {

        List<String> list = new ArrayList<>();
        int startString = 0;

        if (words.length > 1) {
            int i = 1;
            for (; i < words.length - 1; ) {
                if ((i + 1 < words.length) && (freq(words[startString])).equals(freq(words[i]))) {
                    i++;
                } else {
                    list.add(words[startString]);
                    startString = i;
                    i++;
                }
            }
            list.add(words[startString]);
            if (!(freq(words[startString])).equals(freq(words[words.length - 1]))) {
                list.add(words[words.length - 1]);
            }


        } else {
            list.add(words[startString]);
        }


        return list;
    }

    private static String freq(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        String ans = "";
        for (int el : freq) {
            ans += el;
        }
        return ans;
    }

}
