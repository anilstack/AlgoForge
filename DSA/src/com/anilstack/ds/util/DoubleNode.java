package com.anilstack.ds.util;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class DoubleNode {
        public int val;
        public DoubleNode prev;
        public DoubleNode next;
        public DoubleNode child;

        public DoubleNode(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
            this.child = null;
        }
}
