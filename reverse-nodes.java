// TC: O(n)
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy;
        int i = 0;
        
        while (head != null) {
            i++;
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode prev = begin;
        ListNode curr = begin.next;
        ListNode fast = begin.next.next;
        ListNode first = curr;
        
        while (fast != end) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        first.next = end;
        begin.next = curr;
        return first;
    }
}
