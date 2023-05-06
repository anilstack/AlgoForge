package com.anilstack.ds.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 * <p>
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 * <p>
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 * <p>
 * Return a list of integers representing the size of these parts.
 */
public class PartitionLables {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> list = PartitionLables.partitionLables(s);
        System.out.println(list);
    }

    private static List<Integer> partitionLables(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] lastIndexOfChar = new int[26];
// storing last index of that char occurs in given string.
        for (int i = 0; i < s.length(); i++) {
            lastIndexOfChar[s.charAt(i) - 'a'] = i;
        }

        int i = 0;
        while (i < s.length()) {
            char charStart = s.charAt(i);
            int terminalIndex = lastIndexOfChar[charStart - 'a'];
            for (int j = 0; j <= terminalIndex; j++) {
                terminalIndex = Math.max(terminalIndex, lastIndexOfChar[s.charAt(j) - 'a']);
            }
            ans.add(terminalIndex - i + 1);
            i = terminalIndex + 1;
        }
        return ans;
    }
}
