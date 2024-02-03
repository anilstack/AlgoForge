package com.anilstack.ds.trees.dp;

import com.anilstack.ds.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class BinaryTreeMaxPath {

    /**
     *            10
     *           /  \
     *          5    15
     *         / \     \
     *        3   7    18
     * @param args
     */
    public static void main(String[] args) {

//        TreeNode root = new TreeNode(10);
//        root.setLeft(new TreeNode(5));
//        root.setRight(new TreeNode(15));
//        root.getLeft().setLeft(new TreeNode(3));
//        root.getLeft().setRight(new TreeNode(7));
//        root.getRight().setRight(new TreeNode(18));

        TreeNode root = new TreeNode(-10);
        root.setLeft(new TreeNode(9));
        root.setRight(new TreeNode(20));
        root.getRight().setLeft(new TreeNode(15));
        root.getRight().getLeft().setLeft(new TreeNode(9));
        root.getRight().getLeft().setRight(new TreeNode(5));
        root.getRight().setRight(new TreeNode(7));
        root.getRight().getRight().setLeft(new TreeNode(-4));
        root.getRight().getRight().setRight(new TreeNode(-8));

        System.out.println(maxSum(root));
    }

    private static int maxSum = 0;
    private static int maxSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    /**
     * Dynamic Programming Top-Down Approach.
     * @param root
     * @return
     */
    private static int dfs(TreeNode root) {

        Map<TreeNode,Integer> map = new HashMap<>();

        if (root==null) {
            return 0;
        }

        int leftMaxPath = 0;
        int rightMaxPath = 0;

        if (map.containsKey(root.getLeft())) {
            leftMaxPath = map.get(root.getLeft());
        } else {
            leftMaxPath = Math.max(0,dfs(root.getLeft()));
        }

        if (map.containsKey(root.getRight())) {
            rightMaxPath = map.get(root.getRight());
        } else {
            rightMaxPath = Math.max(0,dfs(root.getRight()));
        }

        maxSum = Math.max(maxSum,leftMaxPath + rightMaxPath + root.getVal());

        map.put(root,maxSum);

        return Math.max(leftMaxPath, rightMaxPath) + root.getVal();
    }
}
