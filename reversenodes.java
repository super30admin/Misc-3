//TC: O(n): each node is visited/relinked at most once across all group reversals.
//SC: O(1): constant extra pointers (dummy, start, curr, prev, first, temp).

//Use a dummy head; walk with curr counting nodes—whenever count%k==0, reverse the block [start.next, curr) and set start to the returned tail.
//In reverse(start,end): iteratively flip next pointers for nodes from start.next up to (but not including) end, tracking original head as first.
//Reconnect links (start.next = newHead, first.next = end) and return first (now the tail) to serve as start for the next group.

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = head;
        ListNode start = dummy;
        int count = 0;

        while(curr != null){
            curr = curr.next;
            count++;

            if(count % k == 0){
                start = reverse(start, curr);
            }
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode start, ListNode end){
        ListNode prev = null;
        ListNode curr = start.next;
        ListNode first = start.next;

        while(curr != end){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        start.next = prev;
        first.next = end;

        return first;
    }
}
