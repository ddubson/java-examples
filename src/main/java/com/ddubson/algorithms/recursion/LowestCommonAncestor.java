package com.ddubson.algorithms.recursion;

/**
 * Author: ddubson
 */
public class LowestCommonAncestor {
    public static class Node {
        public Node left = null;
        public Node right = null;
        public int value;
    }

    public static Node LCA(Node root, int a, int b) {
        if(root == null) {
            return null;
        }

        if(root.value == a || root.value == b) {
            return root;
        }

        // walk the subtrees
        Node leftTree = LCA(root.left, a, b);
        Node rightTree = LCA(root.right, a, b);

        if(leftTree!=null && rightTree !=null) {
            return root;
        } else if(leftTree == null && rightTree == null) {
            return null;
        } else {
            return leftTree != null ? leftTree : rightTree;
        }
    }
}
