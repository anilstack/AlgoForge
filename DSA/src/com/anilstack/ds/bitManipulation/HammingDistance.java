package com.anilstack.ds.bitManipulation;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class HammingDistance {

    public static void main(String[] args) {

        int x = 1;
        int y = 4;
        System.out.println(hammingDistance(x,y));
    }

    public static int hammingDistance(int x, int y) {

        int xor = x^y;
        int setBitsCount = 0;
        for (int i=0; i < 32; i++) {
            if (((xor>>i)&1)==1) {
                setBitsCount++;
            }
        }
        return setBitsCount;
    }
}
