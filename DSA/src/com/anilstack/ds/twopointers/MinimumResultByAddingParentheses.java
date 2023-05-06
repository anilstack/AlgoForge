package com.anilstack.ds.twopointers;
/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class MinimumResultByAddingParentheses {

    public static void main(String[] args) {
        String expression = "247+38";
        String result = MinimumResultByAddingParentheses.minResultsByAddingParentheses(expression);
        System.out.println(result);
    }

    private static String minResultsByAddingParentheses(String expression) {

        int smallestVal = Integer.MAX_VALUE;
        int leftParenthesesIndex = -1;
        int rightParenthesesIndex = -1;
        int plusIndex = -1;

        char[] exp = expression.toCharArray();
        for (int i = 0; i < exp.length; i++) {
            if (exp[i] == '+') {
                plusIndex = i;
                break;
            }
        }

        for (int i = 0; i < plusIndex; i++) {
            for (int j = plusIndex + 1; j < expression.length(); j++) {
                int n1 = 1;
                String n1Str = expression.substring(0, i);
                if (n1Str.length() > 0) {
                    n1 = Integer.parseInt(n1Str);
                }

                String n2Str = expression.substring(i, plusIndex);
                int n2 = Integer.parseInt(n2Str);

                String n3Str = expression.substring(plusIndex + 1, j + 1);
                int n3 = Integer.parseInt(n3Str);

                String n4Str = expression.substring(j + 1);
                int n4 = 1;
                if (n4Str.length() > 0) {
                    n4 = Integer.parseInt(n4Str);
                }
                //n1 and n2 are left side before ( will come
                //n3 and n4 are right side ) will come
                int currVal = n1 * (n2 + n3) * n4;
                if (currVal < smallestVal) {
                    smallestVal = currVal;
                    leftParenthesesIndex = i;
                    rightParenthesesIndex = j + 1;
                }
            }
        }

        String ans = "";
        ans += expression.substring(0, leftParenthesesIndex);
        ans += "(";
        ans += expression.substring(leftParenthesesIndex, rightParenthesesIndex);
        ans += ")";
        ans += expression.substring(rightParenthesesIndex);
        return ans;
    }
}
