/*
 * @lc app=leetcode id=191 lang=java
 *
 * [191] Number of 1 Bits
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int weight = 0;
        while (n != 0) {
            if ((n & 1) == 1) weight++;
            n >>>= 1;
        }
        return weight;
    }
}
// @lc code=end

