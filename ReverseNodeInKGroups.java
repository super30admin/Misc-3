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
 // This solution reverses each group of k nodes by taking a range of start to end where start is -1 and end is k+1 nodes at every group
 // In each group after reversing we make sure to put the link of the reversed head to the start.next and tail.next to end
 // Also we make sure to return that tail so that it can act as a new start for next range
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode start = dummy;
        int count = 0;

        ListNode end = head;
        while(end!=null) {
            end=end.next;
            count++;
            if(count%k==0) {
                start = reverse(start, end);
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode start, ListNode end) {

        ListNode tail = start.next;
        ListNode prev = null;
        ListNode curr = start.next;
        while(curr!=end) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        start.next=prev;
        tail.next=end;
        
        return tail;
    }
}
