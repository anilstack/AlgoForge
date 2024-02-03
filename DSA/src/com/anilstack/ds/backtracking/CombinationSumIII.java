package com.anilstack.ds.backtracking;

import java.security.cert.CertPath;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class CombinationSumIII {


    public List<List<Integer>> combinationSum3(int targetedSum, int targetedElements) {

        Set<List<Integer>> set = new HashSet<>();
        combinationSum3Helper(set,targetedSum,targetedElements,new HashSet<>());
        return new ArrayList<>(set);
    }

    public void combinationSum3Helper(Set<List<Integer>> ans, int targetedSum, int targetedElementsSize, Set<Integer> runningSet) {

        if (targetedElementsSize == 0) {
            if (targetedSum == 0) {
                ans.add(new ArrayList<>(runningSet));
                return;
            } else {
                return;
            }
        }

        if (targetedSum < 0) {
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!runningSet.contains(i)) {
                runningSet.add(i);
                combinationSum3Helper(ans,targetedSum - 1, targetedElementsSize - 1,runningSet);
                runningSet.remove(i);
            }
        }



    }



    public static void main(String[] args) {

        CombinationSumIII combinationSumIII = new CombinationSumIII();
        System.out.println(combinationSumIII.combinationSum3(7,3));

    }
}
