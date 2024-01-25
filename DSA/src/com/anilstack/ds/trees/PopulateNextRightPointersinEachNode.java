package com.anilstack.ds.trees;

import com.anilstack.ds.util.NextRighPointerNode;

import java.security.PublicKey;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class PopulateNextRightPointersinEachNode {

    /**
     *           1
     *          / \
     *         2   3
     *        / \ / \
     *       4  5 6  7
     * @param args
     */
    public static void main(String[] args) {
        NextRighPointerNode root = new NextRighPointerNode(1);
        root.left = new NextRighPointerNode(2);
        root.right = new NextRighPointerNode(3);
        root.left.left = new NextRighPointerNode(4);
        root.left.right = new NextRighPointerNode(5);
        root.right.left = new NextRighPointerNode(6);
        root.right.right = new NextRighPointerNode(7);

        root.populateNextPointer(root);

        // Accessing the next pointers
//        System.out.println(root.val + " -> " + (root.next != null ? root.next.val : -1));
//        System.out.println(root.left.val + " -> " + (root.left.next != null ? root.left.next.val : -1));
        NextRighPointerNode addedImmediateRightNodeToTree = connect(root);
        System.out.println(addedImmediateRightNodeToTree.val + " -> " + (addedImmediateRightNodeToTree.next != null ? addedImmediateRightNodeToTree.next.val : -1));
        System.out.println(addedImmediateRightNodeToTree.left.right.val + " -> " + (addedImmediateRightNodeToTree.left.right.next != null ? addedImmediateRightNodeToTree.left.right.next.val : -1));
    }


    /**
     * When you want to do level order search for a tree then BFS is best choice.
     * @param root
     * @return
     */
    public static NextRighPointerNode connect(NextRighPointerNode root) {

        if (root == null) return root;

        Queue<NextRighPointerNode> bfs = new LinkedList<>();
        bfs.offer(root);

        while (!bfs.isEmpty()) {

            int size = bfs.size();
            NextRighPointerNode nextRightNode = null;

            while (size -- > 0) {

                NextRighPointerNode head = bfs.poll();
                head.next = nextRightNode;
                nextRightNode = head;

                if (head.right != null) bfs.offer(head.right);
                if (head.left != null) bfs.offer(head.left);

            }
        }
        return root;
    }



}
