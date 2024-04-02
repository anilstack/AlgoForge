package com.anilstack.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ExpressionAddOperators {

    public static List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        String num = "123";
        int target = 6;
        System.out.println(ExpressionAddOperators.addOperator(num,target));
    }

    public static List<String> addOperator(String num, int target) {
        backtracking(0,"",0,0,num,target);
        return ans;
    }

    private static void backtracking(int i, String expression, long resultSoFar, long prevNum, String num, int target) {

        if (i == num.length()) {
            if (resultSoFar == target) {
                ans.add(expression);
                return;
            }
        }

        for (int j=i;j<num.length();j++) {

            if (j > i && num.charAt(i) == '0') {
                break;
            }

            long currNum = Long.parseLong(num.substring(i,j+1));
            if (i == 0) {
                backtracking(j+1,expression + currNum,currNum,currNum,num,target);
            } else {
                backtracking(j + 1, expression + "+" +currNum,resultSoFar + currNum, currNum, num, target);
                backtracking(j+1, expression + "-" +currNum, resultSoFar - currNum, -currNum,num, target);
                backtracking(j+1, expression + "*" +currNum, resultSoFar - prevNum + prevNum * currNum, prevNum * currNum, num, target);
            }
        }
    }


}
