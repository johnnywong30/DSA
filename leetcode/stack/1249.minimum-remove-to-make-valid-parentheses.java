/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

// @lc code=start
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder valid = new StringBuilder();
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(i);
            }
            else if (c == ')') {
                // there is a matching open paren for this closing paren
                if (! stack.isEmpty() && s.charAt(stack.getLast()) == '(') {
                    stack.removeLast();
                }
                else {
                    // we have a mismatch that we will remove later
                    stack.add(i);
                }
            }
            // append c anyway because we will remove mismatched parens later
            valid.append(c);
        }
        while (! stack.isEmpty()) {
            valid.deleteCharAt(stack.removeLast());
        }
        return valid.toString();
    }
}
// @lc code=end

