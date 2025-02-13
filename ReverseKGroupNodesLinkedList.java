// Time Complexity: O(n)
//Space Complexity; O(1)

//Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class ReverseKGroupNodesLinkedList {
    public ListNode reverseKGroup(ListNode head, int k) {
        // base case
        if (head == null || k == 1) return head;
        int length = 0;
        ListNode temp = head;
        while (temp != null) { // Count number of nodes in list
            length++;
            temp = temp.next;
        }

        // initialize dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        // reverse nodes in group of k

        while (length >= k) {
            ListNode curr = prevGroupEnd.next;
            ListNode next = curr.next;
            // reverse nodes
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prevGroupEnd.next;
                prevGroupEnd.next = next;
                next = curr.next;
            }

            // move prevGroupEnd to the end of reversed group
            prevGroupEnd = curr;
            length -= k;

        }
        return dummy.next;

    }
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2; // Reverse in groups of k

        ReverseKGroupNodesLinkedList solution = new ReverseKGroupNodesLinkedList();
        ListNode newHead = solution.reverseKGroup(head, k);

        // Print the updated linked list
        printList(newHead);
    }

    // Helper function to print the linked list
    private static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
