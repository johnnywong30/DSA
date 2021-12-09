/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        // validate right side of BST
        if (min != null && root.val <= min) return false;
        // validate left side of BST
        if (max != null && root.val >= max) return false;
        boolean left = isValidBST(root.left, min, root.val);
        boolean right = isValidBST(root.right, root.val, max);
        return left && right;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
}
// @lc code=end

