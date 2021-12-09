/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') stack.add(c);
            else if (stack.isEmpty()) return false;
            else if (c == ')' && stack.getLast() == '(') stack.removeLast();
            else if (c == ']' && stack.getLast() == '[') stack.removeLast();
            else if (c == '}' && stack.getLast() == '{') stack.removeLast();
            else return false;
        }
        return stack.isEmpty();
    }
}
// @lc code=end

