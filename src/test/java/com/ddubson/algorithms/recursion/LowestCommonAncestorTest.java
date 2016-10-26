package com.ddubson.algorithms.recursion;

import org.junit.Test;

import static com.ddubson.algorithms.recursion.LowestCommonAncestor.LCA;
import static org.junit.Assert.assertEquals;

/**
 * Author: ddubson
 */
public class LowestCommonAncestorTest {
    @Test
    public void LCA_TEST() throws Exception {
        // null root
        assertEquals(null, LCA(nullTree(), 1, 1));

        // one node tree
        assertEquals(null, LCA(oneNodeTree(), 5, 4));

        // three node tree / balanced
        assertEquals(7, LCA(threeNodeTree(), 5, 4).value);

        // three node Ltree / balanced with no LCA found
        assertEquals(5, LCA(unbalancedThreeNodeTree(), 5, 4).value);
    }

    private LowestCommonAncestor.Node oneNodeTree() {
        LowestCommonAncestor.Node root = new LowestCommonAncestor.Node();
        root.value = 7;
        return root;
    }

    private LowestCommonAncestor.Node unbalancedThreeNodeTree() {
        LowestCommonAncestor.Node root = new LowestCommonAncestor.Node();
        LowestCommonAncestor.Node left = new LowestCommonAncestor.Node();
        LowestCommonAncestor.Node right = new LowestCommonAncestor.Node();
        left.value = 5;
        right.value = 4;
        root.value = 7;
        root.left = left;
        left.left = right;
        return root;
    }

    private LowestCommonAncestor.Node threeNodeTree() {
        LowestCommonAncestor.Node root = new LowestCommonAncestor.Node();
        LowestCommonAncestor.Node left = new LowestCommonAncestor.Node();
        LowestCommonAncestor.Node right = new LowestCommonAncestor.Node();
        left.value = 5;
        right.value = 4;
        root.value = 7;
        root.left = left;
        root.right = right;
        return root;
    }

    private LowestCommonAncestor.Node nullTree() throws Exception {
        return null;
    }
}