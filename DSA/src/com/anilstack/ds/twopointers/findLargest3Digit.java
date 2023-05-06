package com.anilstack.ds.twopointers;


/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class findLargest3Digit {

    public static void main(String[] args) {
        String s = "677789333";
        String result = findLargest3Digit.largestGoodInteger(s);
        System.out.println(result);
    }

    private static String largestGoodInteger(String s) {
        int start = 0;
        int ans = -1;
        int i = 0;

        while (i < s.length()) {
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                i++;
            //    continue;
            } else {
                int len = i - start + 1;
                if (len >= 3) {
                    ans = Math.max(ans, s.charAt(start) - '0');
                }
                start = i + 1;
                i++;
            }
        }

        if (ans != -1) {
            return ans + "" + ans + "" + ans;
        } else {
            return "";
        }
    }
}
