package com.anilstack.ds.twopointers;

import java.util.Arrays;

/**
 *  @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class BagOfTokens {
//TC: O(n log n)
//SC: O(1)
    public static void main(String[] args) {
      int[] tokens = {100,300,200,400};
      int power = 200;
      int maxScore = BagOfTokens.bagOfTokensScore(tokens, power);
      System.out.println(maxScore);
    }
//    Your goal is to maximize your total score by potentially playing each token in one of two ways:
//
//    If your current power is at least tokens[i], you may play the ith token face up, losing tokens[i] power and gaining 1 score.
//    If your current score is at least 1, you may play the ith token face down, gaining tokens[i] power and losing 1 score.
    private static int bagOfTokensScore(int[] tokens, int power) {

        Arrays.sort(tokens);

        int score = 0;
        int maxScore = 0;

        int left = 0;
        int right = tokens.length - 1;

        while (left <= right) {
            if (power >= tokens[left]) {
                    power -= tokens[left];
                    score = score + 1;
                    left++;
                    maxScore = Math.max(score,maxScore);
            } else if (score > 0) {
                power += tokens[right];
                right--;
                score--;
            } else {
                break;
            }
        }
            return maxScore;
    }
}
