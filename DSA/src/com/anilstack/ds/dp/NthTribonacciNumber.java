package com.anilstack.ds.dp;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class NthTribonacciNumber {

    public static void main(String[] args) {
        int n=5;
        System.out.println(findNthTribonacciNumber(n));
    }

    public static int findNthTribonacciNumber(int n) {

        if (n==0) return 0;
        if (n<=2) return 1;

        int a = 0;
        int b = 1;
        int c = 1;
        int sum = 0;
        int index = 3;

        while (index <= 3) {
            sum = a+b+c;
            index++;
            a=b;
            b=c;
            c=sum;
        }
        return sum;

    }


}
