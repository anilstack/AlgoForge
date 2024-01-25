package com.anilstack.ds.util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class NextRighPointerNode {

    public int val;
   public NextRighPointerNode left;
    public NextRighPointerNode right;
    public NextRighPointerNode next;

    public NextRighPointerNode(int value) {
        val = value;
        left = null;
        right = null;
        next = null;
    }



    public static void populateNextPointer(NextRighPointerNode root) {
        if (root == null) {
            return;
        }

        Queue<NextRighPointerNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            NextRighPointerNode prev = null;

            for (int i = 0; i < size; i++) {
                NextRighPointerNode current = queue.poll();

                if (prev != null) {
                    prev.next = current;
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }

                prev = current;
            }
        }
    }
}



