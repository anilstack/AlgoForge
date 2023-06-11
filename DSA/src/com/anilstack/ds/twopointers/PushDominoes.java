package com.anilstack.ds.twopointers;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class PushDominoes {

    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";
        System.out.println(PushDominoes.pushDominoes(dominoes));
    }
    private static String pushDominoes(String dominoes) {

        int n=dominoes.length();
        int[] leftForce = new int[n];
        int[] rightForce = new int[n];
        int nearestLeftIndex = -1;
        int nearestRightIndex = -1;
        for (int i = n-1; i >=0; i--) {
            char c = dominoes.charAt(i);
            if (c == 'L') {
                nearestLeftIndex = i;
            } else if (c == 'R') {
                nearestLeftIndex = -1;
            }
            leftForce[i] = nearestLeftIndex;
        }

        for (int i = 0; i < dominoes.length(); i++) {
            char c = dominoes.charAt(i);
            if (c == 'L') {
                nearestRightIndex = -1;
            } else if (c == 'R') {
                nearestRightIndex = i;
            }
            rightForce[i] = nearestRightIndex;
        }

        char [] ans = new char[n];
        for (int i = 0; i<n;i++) {
            if (dominoes.charAt(i) == '.') {
                int nearestLeft = leftForce[i];
                int nearestRight = rightForce[i];

                int leftDiff = nearestLeft == -1 ? Integer.MAX_VALUE : Math.abs(nearestLeft - i);
                int rightDiff = nearestRight == -1 ? Integer.MAX_VALUE : Math.abs(nearestRight - i);

                if (leftDiff == rightDiff) {
                    ans[i] = '.';
                } else if (leftDiff < rightDiff) {
                    ans[i] = 'L';
                } else if (leftDiff > rightDiff) {
                    ans[i] = 'R';
                }
            } else {
                ans[i] = dominoes.charAt(i);
            }
        }
        return new String(ans);
    }
}
