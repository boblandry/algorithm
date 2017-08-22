package com.lichking.solution;

import com.lichking.entity.TreeNode;

/**
 * 求树的最短深度 
 * Given a binary tree, find its minimum depth.The minimum depth is the
 * number of nodes along the shortest path from the root node down to the
 * nearest leaf node.
 * 
 * @author LichKing
 *
 */
public class MinDepthOfTree {

	public int run(TreeNode root) {
		return getMinDepth(root);
	}

	public boolean isLeaf(TreeNode node) {
		if (node.left == null && node.right == null)
			return true;
		return false;
	}

	public int getMinDepth(TreeNode node) {
		if (node == null)
			return 0;
		if (isLeaf(node))
			return 1;
		if (node.left == null)
			return getMinDepth(node.right) + 1;
		if (node.right == null)
			return getMinDepth(node.left) + 1;
		else {
			int leftDepth = getMinDepth(node.left);
			int rightDepth = getMinDepth(node.right);
			if (leftDepth < rightDepth)
				return leftDepth + 1;
			else
				return rightDepth + 1;
		}

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(0);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		TreeNode t = new TreeNode(1);
		left.left = t;
		root.left = left;
		root.right = right;
		//System.out.println(new Solution().run(root));
	}
	
}
