# Problem 2: Reverse nodes in k groups (https://leetcode.com/problems/reverse-nodes-in-k-group/)
# Time Complexity: O(n),Each node is visited once by the main loop and at most once inside reverse.
# Space Complexity: O(1), Only a few pointers are used. Reversal is done in place.
# Approach:
# Walk through the list and count nodes.
# When count is a multiple of k, we have a full group.
# Reverse only that group and reconnect it to the rest of the list.
# Leftover nodes (fewer than k) are never reversed.
# A dummy node before head handles the case where the head changes.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: ListNode | None, k: int) -> ListNode | None:
        dummy = ListNode(-1)      # fake node before head
        dummy.next = head

        current = head            # walks forward
        start = dummy             # node just before the current group
        count = 0                 # nodes passed so far

        while current is not None:
            current = current.next    # move forward
            count += 1

            # full group found, current is now the node after the group
            if count % k == 0:
                # reverse the group, returned tail becomes next start
                start = self.reverse(start, current)

        return dummy.next         # new head

    # Reverses nodes strictly between start and end
    def reverse(self, start: ListNode, end: ListNode) -> ListNode:
        previous = None           # what a flipped node will point to
        current = start.next      # first node of the group
        first = start.next        # becomes the tail after reversing

        while current != end:
            temp = current.next       # save next node
            current.next = previous   # flip the arrow
            previous = current        # move previous forward
            current = temp            # move current forward

        start.next = previous     # connect before-part to new front
        first.next = end          # connect new tail to after-part

        return first              # tail of group, anchor for next group