/*
 * @lc app=leetcode id=389 lang=java
 *
 * [389] Find the Difference
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        char diff = '!';
        for (int i = 0; i < s.length(); i++) {
            diff ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            diff ^= t.charAt(i);
        }
        return (char) (diff ^ '!');
    }
}
// @lc code=end

