package com.anilstack.ds.twopointers;

import java.util.Arrays;

/**
 *  @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class CheckDistance {

    public static void main(String[] args) {
            String s = "abaccb";
            int[] distance = {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            Boolean isDistanceMatched = CheckDistance.checkDistanceBetweenSameChar(s,distance);
            System.out.println(isDistanceMatched);
    }

    private static boolean checkDistanceBetweenSameChar(String s, int[] distance) {

        int[][] indicesList = new int[26][2];

        for (int[] indices : indicesList) {
            Arrays.fill(indices, -1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int[] indices = indicesList[c-'a'];
            if (indices[0] == -1) {
                indices[0] = i;
            } else {
                indices[1] = i;
            }
        }

        for (int i = 0; i < distance.length; i++) {
            if (indicesList[i][0] != -1 && indicesList[i][1] != -1) {
                   int actualDistance =  indicesList[i][1] - indicesList[i][0] - 1;
                   if (actualDistance != distance[i]) {
                        return false;
                   }
            }
        }
        return true;
    }
}
