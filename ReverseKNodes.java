//Time Complexity:O(n);
//SPace Complexity:O(1);
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
        if(head == null || head.next == null || k == 1) return head;
        ListNode start;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        start = dummy;
        int i = 0;
        while(head != null){
            i++;
            if(i % k == 0){
                start = reverse(start, head.next);
                head = start.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode start, ListNode end){
        ListNode prev = start;
        ListNode curr = start.next;
        ListNode fast = start.next.next;
        ListNode first = curr;
        while(fast != end){
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