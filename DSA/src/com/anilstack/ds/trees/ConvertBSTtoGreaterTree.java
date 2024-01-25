package com.anilstack.ds.trees;

import com.anilstack.ds.util.TreeNode;
import com.anilstack.ds.util.TreeNodeV1;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ConvertBSTtoGreaterTree {

    private static Integer greaterValueCount = 0;

    /**
     *          4
     *        /   \
     *       1     6
     *      / \   / \
     *     0   2 5   7
     *          \     \
     *           3     8
     * @param args
     */
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
        System.out.println("Inorder Traversal:");
        inorderTraversal(root);
        TreeNode greaterTree = convertBST(root);
        System.out.println("after converting into greater tree");
        inorderTraversal(greaterTree);
    }

    /**
     * InOrder: Left,Root,Right
     * PreOrder: Root,Left,Right
     * PostOrder: Left,Right,Root.
     *
     *   we are following reverse in-order traversal Inorder is : Left,Root,Right
     *   so in this example we are following reverse in-order i.e., Right,Root,Left.
     *
     *
     * @param root
     * @return
     */
    private static TreeNode convertBST(TreeNode root) {

        if (root==null) return root;

        convertBST(root.getRight());
        root.setVal(root.getVal()+greaterValueCount);
        greaterValueCount = root.getVal();
        convertBST(root.getLeft());
        return root;
    }






    private static void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.getLeft());
            System.out.print(node.getVal() + " ");
            inorderTraversal(node.getRight());
        }
    }

}
