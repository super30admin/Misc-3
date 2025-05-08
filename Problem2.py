# Problem 2 : Reverse Nodes in k-Group
# Time Complexity : O(n) where n is the number of nodes in the list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach
from typing import Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        # define dummy node
        dummy = ListNode(-1)
        # point next of dummy to head
        dummy.next = head
        # define start that points to dummy
        start = dummy
        # define variable count to count the nodes for the group
        count = 0
        # point curr to start
        curr = start

        # loop till next of curr is not None
        while curr.next:
            # move the curr to next node
            curr = curr.next
            # increment count
            count += 1
            # check if count % k is 0 and if it is then call reverse function with start and next node of curr and store return node in curr
            if count % k == 0:
                curr = self.reverse(start, curr.next)
                # set the start to curr node
                start = curr
        # return next node of dummy
        return dummy.next

    # reverse function to the reverse the linked list between start node and end node
    def reverse(self, start: ListNode, end: ListNode) -> ListNode:
        # define first to next node of start
        first = start.next
        # define prev which point to start node
        prev = start
        # define curr and set to next node of start
        curr = start.next
        # define fast and set to next node of curr
        fast = curr.next

        # loop till fast is equal to end
        while fast != end:
            # point next potiner of curr to prev node
            curr.next = prev
            # set prev to curr
            prev = curr
            # set curr to fast
            curr = fast
            # move fast to next node of fast
            fast = fast.next

        # set the next pointer of curr to prev
        curr.next = prev
        # set the next pointer of first to end
        first.next = end
        # set the next pointer of start to curr
        start.next = curr
        # return the first node
        return first
        