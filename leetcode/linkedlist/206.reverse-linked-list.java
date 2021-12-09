/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // prev is what we will return
        // after reversing the list, prev is our new head
        ListNode prev = null;
        while (head != null) {
            // save next node to traverse list to reverse
            ListNode after = head.next;
            // flip the direction
            head.next = prev;
            // point to last node used
            prev = head;
            // move on to next node to flip
            head = after;
        }
        return prev;
    }
}
// @lc code=end

