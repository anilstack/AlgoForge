    package com.anilstack.ds.trees;

    import com.anilstack.ds.util.TreeNode;

    /**
     * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
     */
    public class ConstructBinaryTreeFromPostOrderAndInOrder {

//        private static int pos = 0;
//
//        public static void main(String[] args) {
//
//            int[] inorder = {9,3,15,20,7};
//            int[] postorder = {9,15,7,20,3};
//
//            TreeNode head = buildTree(inorder,postorder);
//            printInOrder(head);
//           // System.out.println(head.getVal());
//        }
//    //postOrder = Left,Right,Root
//    //InOrder = Left,Root,Right
//        public static TreeNode buildTree(int[] inorder, int[] postorder) {
//
//            pos = postorder.length-1;
//            TreeNode node = constructTree(inorder,postorder,0,inorder.length-1);
//            return node;
//        }
//
//        private static TreeNode constructTree(int[] inorder, int[] postorder, int startIn, int endIn) {
//
//        if (pos < 0 || startIn > endIn ) {
//            return null;
//        }
//
//        int val = postorder[pos];
//
//        TreeNode node = new TreeNode(val);
//        pos--;
//
//        int i = startIn;
//        for (;i<endIn;i++) {
//            if (val == inorder[i]) {
//                break;
//            }
//        }
//
//               TreeNode right  = constructTree(inorder,postorder,i+1,endIn);
//               TreeNode left = constructTree(inorder,postorder,startIn,i-1);
//
//               node.setRight(right);
//               node.setLeft(left);
//
//            return node;
//
//        }
//
//        public static void printInOrder(TreeNode root) {
//            if (root != null) {
//                printInOrder(root.getLeft());
//                System.out.print(root.getVal() + " ");
//                printInOrder(root.getRight());
//            }
//        }
        private static int pos = 0;
        public static void main(String[] args) {
            int[] inorder = {9,3,15,20,7};
            int[] postorder = {9,15,7,20,3};
            printInOrder(buildTree(inorder,postorder));
        }


        public static TreeNode buildTree(int[] inorder, int[] postorder) {

            pos = postorder.length - 1;
            TreeNode root = constructTree(inorder, postorder, 0, inorder.length - 1);
            return root;
        }

        private static TreeNode constructTree(int[] inorder, int[] postorder, int startIn, int endIn) {

            if (pos < 0 || startIn > endIn) {
                return null;
            }

            int val = postorder[pos];

            TreeNode node = new TreeNode(val);
            pos--;

            int i = startIn;
            for (; i < endIn; i++) {
                if (val == inorder[i]) {
                    break;
                }
            }

            TreeNode right = constructTree(inorder, postorder, i + 1, endIn);
            TreeNode left = constructTree(inorder, postorder, startIn, i - 1);

            node.setRight(right);
            node.setLeft(left);

            return node;

        }

        public static void printInOrder(TreeNode root) {
            if (root != null) {
                printInOrder(root.getLeft());
                System.out.print(root.getVal() + " ");
                printInOrder(root.getRight());
            }
        }
    }





