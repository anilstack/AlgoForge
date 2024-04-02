package com.anilstack.ds.graph;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class FindTownJudge {


    public static void main(String[] args) {
        int[][] trust = {{1,3},{2,3},{4,3}};
        int n = 4;
        System.out.println(findJudge(n,trust));
    }

    /**
     * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
     *
     * If the town judge exists, then:
     *
     * The town judge trusts nobody.
     * Everybody (except for the town judge) trusts the town judge.
     * @param n
     * @param trust
     * @return
     */
    public static int findJudge(int n, int[][] trust) {

        int[] inwardDegree = new int[n+1];
        int[] outwardDegree = new int[n+1];
        for (int i=0; i < trust.length; i++) {
            int currOut = outwardDegree[trust[i][0]];
            outwardDegree[trust[i][0]] = currOut + 1;
            int countIn = inwardDegree[trust[i][1]];
            inwardDegree[trust[i][1]] = countIn + 1;
        }

        for (int i = 1; i <= n; i++) {
            if (outwardDegree[i]==0 && inwardDegree[i]==n-1) {
                return i;
            }
        }
        return -1;




    }
}
