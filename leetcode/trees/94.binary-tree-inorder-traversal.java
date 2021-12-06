/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    // preorder traversal: root left right
    // inorder traversal: left root right
    // postorder traversal: left right root
    private List<Integer> traversal = new LinkedList<>();
    
    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        traversal.add(root.val);
        traverse(root.right);
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return traversal;
    }
}
// @lc code=end

