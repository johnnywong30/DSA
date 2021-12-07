/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        // XOR is commutative, so (4 ^ 1 ^ 2 ^ 1 ^ 2) is the same as
        // (1 ^ 1) ^ (2 ^ 2) ^ 4 = 0 ^ 0 ^ 4 = 4
        for (int n: nums) {
            single ^= n;
        }
        return single;
    }
}
// @lc code=end

