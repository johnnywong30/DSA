/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    // preorder: root left right
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversal = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null) {
            // add current
            traversal.add(curr.val);
            // save the right side
            if (curr.right != null) {
                stack.add(curr.right);
            }
            // go left
            curr = curr.left;
            if (curr == null && ! stack.isEmpty()) {
                curr = stack.removeLast();
            }
        }
        return traversal;
    }
}
// @lc code=end

