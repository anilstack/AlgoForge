package com.anilstack.ds.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class Fibonacci {

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Fibonacci WithRecursion ::"+fibWithRecursion(n));
        System.out.println("Fibonacci WithDPBottomUp ::"+fibWithDPBootomUp(n));
        System.out.println("Fibonacci WithConstanst spcae ::"+fibWithConstantSpace(n));
    }

    public static int fibWithRecursion(int n) {
        // n, fib(n)
        Map<Integer,Integer> map = new HashMap<>();
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n==0) {
            return 0;
        } else if(n==1) {
            return 1;
        } else {
            //return fibWithRecursion(n-1) + fibWithRecursion(n-2);
            int fibN = fibWithRecursion(n-1) + fibWithRecursion(n-2);
            map.put(n,fibN);
            return fibN;
        }

    }

    /**
     * TC:O(n)
     * SC:O(n)
     * @param n
     * @return
     */
    public static int fibWithDPBootomUp(int n) {
        if (n<=1) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2;i<=n;i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    /**
     * TC:O(n)
     * SC:O(1)
     */
    public static int fibWithConstantSpace(int n) {

        if (n<=1) return n;
        int a = 0;
        int b = 1;
        int total = a + b;
        for (int i=2;i<=n;i++) {
            total = a+b;
            a=b;
            b=total;
        }
        return total;
    }

}
