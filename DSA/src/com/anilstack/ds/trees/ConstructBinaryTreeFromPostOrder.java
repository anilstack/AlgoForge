package com.anilstack.ds.trees;

import com.anilstack.ds.util.TreeNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ConstructBinaryTreeFromPostOrder {

    private static int index = 0;

    public static void main(String[] args) {

        int[] arr = {8,5,1,7,10,12};
        TreeNode node = bstFromPreorder(arr);
        node.postOrderTraversal(node);
    }

    private static TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);

    }

    private static TreeNode helper(int[] preorder, int start,int end) {

        if (index >= preorder.length || preorder[index] < start || preorder[index] > end) {
            return null;
        }

        int val = preorder[index];
        TreeNode node = new TreeNode(val);
        index++;
        node.setLeft(helper(preorder,start,val));
        node.setRight(helper(preorder,val,end));
        return node;
    }
}
