package com.anilstack.ds.trees;

import com.anilstack.ds.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class TwoSum {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.setLeft(new TreeNode(1));
        root.setRight(new TreeNode(6));
        root.getLeft().setLeft(new TreeNode(0));
        root.getLeft().setRight(new TreeNode(2));
        root.getRight().setLeft(new TreeNode(5));
        root.getRight().setRight(new TreeNode(7));
        root.getLeft().getRight().setRight(new TreeNode(3));
        root.getRight().getRight().setRight(new TreeNode(8));
        System.out.println(findTarget(root,10));

    }

    private static boolean findTarget(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();
        inorder(root,list);

        int left = 0;
        int right = list.size()-1;

        while (left < right) {
            if (list.get(left) + list.get(right) < k) {
                left++;
            } else {
                right--;
            }
            if (list.get(left) + list.get(right) == k) return true;
        }
        return false;
    }

    private static void inorder(TreeNode root, List<Integer> list) {

        if (root==null) return;

        inorder(root.getLeft(),list);
        list.add(root.getVal());
        inorder(root.getRight(),list);

    }
}
