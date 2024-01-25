package com.anilstack.ds.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
@Data
@Setter
@Getter
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public static void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.getLeft());
            System.out.print(node.getVal() + " ");
            inorderTraversal(node.getRight());
        }
    }

    public static void postOrderTraversal(TreeNode node) {
        if (node!=null) {
            System.out.println(node.getVal() + " ");
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
        }
    }
}


