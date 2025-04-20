/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode ReverseKGroup(ListNode head, int k) {
        if(head == null || k <= 0){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int count = 0;
        ListNode begin = dummy;

        while(head != null){
            count++;
            if(count % k == 0){
                begin = Reverse(begin, head.next);
                head = begin;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode Reverse(ListNode begin, ListNode end){
        ListNode first = begin.next;
        ListNode prev = null;
        ListNode current = begin.next;
        ListNode fast = current.next;
        while(fast != end){
            current.next = prev;
            prev = current;
            current = fast;
            fast = fast.next;
        }
        current.next = prev;
        begin.next = current;
        first.next = end;
        return first;
    }
}