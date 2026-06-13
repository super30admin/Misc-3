// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We traverse through the list and whenever we find group of k nodes, we reverse them. We maintain a dummy
node to preserve the head and also a start node to keep track of the beginning of the group. After reversing
the nodes, we also need to ensure the connections with start and end node of the reversed group's links
are updated acoordingly for the next group reversal.
 */

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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode start = dummy;
        ListNode curr = head;
        int count = 0;

        while(curr != null) {
            curr = curr.next;
            count++;

            if(count == k) {
                count = 0;
                start = reverseGroup(start, curr);
            }
        }
        return dummy.next;
    }

    private ListNode reverseGroup(ListNode start, ListNode end) {
        ListNode curr = start.next;
        ListNode prev = start;

        while (curr != end) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        ListNode firstNode = start.next;
        start.next = prev;
        firstNode.next = curr;

        return firstNode;
    }
}