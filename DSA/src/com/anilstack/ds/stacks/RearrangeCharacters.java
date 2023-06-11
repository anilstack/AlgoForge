package com.anilstack.ds.stacks;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class RearrangeCharacters {

    public static void main(String[] args) {
        String s = "ilovecodingonleetcode";
        String t = "code";
        System.out.println(RearrangeCharacters.rearrangeCharactersToGetTarget(s,t));
    }

    private static int rearrangeCharactersToGetTarget(String s, String target) {

        int[] freqs = getFrequency(s);
        int[] freqt = getFrequency(target);

        int ans = Integer.MAX_VALUE;
        for (int i=0; i<26; i++) {
            if (freqt[i] > 0) {
                ans = Math.min(freqs[i]/freqt[i],ans);
            }
        }


        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private static int[] getFrequency(String s) {

        int[] freq = new int[26];
        for (char c:s.toCharArray()) {
            freq[c-'a']++;
        }
        return freq;
    }

}
