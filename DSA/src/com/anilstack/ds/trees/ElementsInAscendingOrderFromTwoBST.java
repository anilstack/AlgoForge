package com.anilstack.ds.trees;

import com.anilstack.ds.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ElementsInAscendingOrderFromTwoBST {

    public static void main(String[] args) {

        TreeNode node1  = new TreeNode(2);
        node1.setLeft(new TreeNode(1));
        node1.setRight(new TreeNode(4));

        TreeNode node2  = new TreeNode(1);
        node2.setLeft(new TreeNode(0));
        node2.setRight(new TreeNode(3));

        System.out.println("list of elements in ascending order::"+getAllElements(node1,node2));

    }


    private static List<Integer> getAllElements(TreeNode node1, TreeNode node2) {
        List<Integer> list1 = new ArrayList<>();
        inorder(node1,list1);
        List<Integer> list2 = new ArrayList<>();
        inorder(node2,list2);
        return merge(list1,list2);
    }


    private static List<Integer> merge(List<Integer> list1, List<Integer> list2) {

        List<Integer> result = new ArrayList<>();
        int firstListPointer = 0;
        int secondListPointer = 0;

        while(firstListPointer < list1.size() && secondListPointer < list2.size()) {
            if (list1.get(firstListPointer) < list2.get(secondListPointer)) {
                result.add(list1.get(firstListPointer));
                firstListPointer++;
            } else {
                result.add(list2.get(secondListPointer));
                secondListPointer++;
            }
        }

        while (firstListPointer < list1.size()) {
            result.add(list1.get(firstListPointer));
            firstListPointer++;
        }

        while (secondListPointer < list2.size()) {
            result.add(list2.get(secondListPointer));
            secondListPointer++;
        }
        return result;
    }

    private static void inorder(TreeNode node, List<Integer> list) {
        if (node==null) return;

        inorder(node.getLeft(),list);
        list.add(node.getVal());
        inorder(node.getRight(),list);
    }


}
