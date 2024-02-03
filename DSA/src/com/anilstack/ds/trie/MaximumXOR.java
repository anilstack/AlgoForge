package com.anilstack.ds.trie;

import com.anilstack.ds.util.TrieNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class MaximumXOR {

    private class Trie {

        Trie[] children;

        public Trie() {
            children = new Trie[2];
        }

    }

    private Trie root;

    public void buildTree(int[] nums) {

        for (int num : nums) {

            Trie curNode = root;

            for (int i = 31; i >= 0; i--) {

                int currBit = (num >>> i) & 1;

                if (curNode.children[currBit] == null) {
                        curNode.children[currBit] = new Trie();
                }

                curNode = curNode.children[currBit];

            }
        }
    }

    private int findMaxXorForCurrentElement(int num) {

        Trie curNode = root;
        int targetNum = 0;
        for (int i = 31; i >= 0; i--) {

            int currBit = (num >>> i) & 1;
            int targetBit = currBit == 0 ? 1 : 0;
            if (curNode.children[targetBit] != null) {
                targetNum = targetNum * 2 + targetBit;
                curNode = curNode.children[targetBit];
            } else {
                targetNum = targetNum * 2 + currBit;
                curNode = curNode.children[currBit];
            }

        }
        return targetNum;
    }


    public int findMaximumXOR(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        root = new Trie();
        buildTree(nums);

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            int maxXORForNum = findMaxXorForCurrentElement(num);
            max = Math.max(maxXORForNum ^ num, max);
        }
        return max;
    }

    public static void main(String[] args) {

        MaximumXOR maximumXOR = new MaximumXOR();
        int[] nums  = {3,10,5,25,2,8};
        System.out.println(maximumXOR.findMaximumXOR(nums));


    }

}
