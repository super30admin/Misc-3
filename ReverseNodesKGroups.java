// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// we maintain the start and end ranges of k number groups => k+2 size list
// we reverse the inner elements but we need to update the head and end of the reversed group
// after reverse, attach start to end of curr list
// attach first to end of group (start of next group)
// need to update start of next group to end of curr reverse list

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        int cnt = 0;
        ListNode start = dummy;

        while (curr.next != null) {
            curr = curr.next;
            cnt++;
            if (cnt % k == 0) {
                start = reverse(start, curr.next);
                curr = start;
            }
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode start, ListNode end) {

        ListNode prev = start;
        ListNode curr = start.next;
        ListNode first = curr;
        ListNode fast = curr.next;

        while (fast != end) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }

        curr.next = prev;
        first.next = end;
        start.next = curr;

        return first;

    }
}