/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    // left right root
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traversal = new LinkedList<>();
        if (root == null) return traversal;
        traversal.addAll(postorderTraversal(root.left));
        traversal.addAll(postorderTraversal(root.right));
        traversal.add(root.val);
        return traversal;
    }
}
// @lc code=end

