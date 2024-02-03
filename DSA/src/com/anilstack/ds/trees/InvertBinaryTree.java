package com.anilstack.ds.trees;

import com.anilstack.ds.util.TreeNode;
import com.sun.source.tree.Tree;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class InvertBinaryTree {


    /**
     *         4
     *        / \
     *       2   7
     *      / \ / \
     *     1  3 6  9
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        // Creates the root node with value 1
        root.setLeft(new TreeNode(2));     // Creates left child with value 2
        root.setRight(new TreeNode(7));    // Creates right child with value 3
        // Creates left child of 2 with value 4
        root.getLeft().setLeft(new TreeNode(1));

        // Creates right child of 2 with value 5
        root.getLeft().setRight(new TreeNode(3));

        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(9));

        TreeNode rootValue = invertTree(root);
        System.out.println(rootValue.getVal());
    }

    public static TreeNode invertTree(TreeNode root) {

        if (root==null) return null;
// we followed post order travesel left,right,root.
       TreeNode leftNode = invertTree(root.getLeft());
       TreeNode rightNode =  invertTree(root.getRight());

       root.setRight(leftNode);
       root.setLeft(rightNode);

       return root;
    }

}
