package com.ddubson.algorithms.trees;

import com.ddubson.datastructures.trees.TreeNode;

/**
 * Created by ddubson on 2/16/16.
 */
public class BalancedBST {
	public static void main(String... args) {
		int[] sortedArray = { 1, 2, 4, 5, 6, 7, 8 };

		TreeNode<Integer> n = createBST(sortedArray, 0, sortedArray.length - 1);
		System.out.println(n.toString());
	}

	private static TreeNode createBST(int[] array, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;
		TreeNode<Integer> root = new TreeNode<>(array[mid]);
		root.setLeft(createBST(array, start, mid - 1));
		root.setRight(createBST(array, mid + 1, end));

		return root;
	}
}
