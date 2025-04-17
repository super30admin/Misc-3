// TC: O(n)
// SC: O(1)

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    private boolean reverse(ListNode prev, int lim) {
        if (prev.next == null)
            return false;
        ListNode start = prev.next;
        ListNode end = start;
        int c = 1;
        while (end.next != null && c < lim) {
            c++;
            end = end.next;
        }
        if (c < lim)
            return false;
        ListNode next = end.next;
        prev.next = null;
        end.next = null;
        ListNode i = null, j = start, k = start.next;
        while (j != null) {
            j.next = i;
            i = j;
            j = k;
            if (k != null)
                k = k.next;
        }
        prev.next = i;
        start.next = next;
        return true;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (reverse(prev, k)) {
            int a = 0;
            while (a < k) {
                prev = prev.next;
                a++;
            }
        }
        return dummy.next;
    }
}