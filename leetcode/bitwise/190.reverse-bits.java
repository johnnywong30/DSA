/*
 * @lc app=leetcode id=190 lang=java
 *
 * [190] Reverse Bits
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed = 0;
        for (int i = 0; i < 32; i++) {
            // shift left by 1 to push last digits to beginning
            reversed <<= 1; 
            // check if last digit is 1
            if ((n & 1) == 1) reversed++;
            // pop off last digit
            n >>= 1;
        }
        
        return reversed;
    }
}
// @lc code=end

