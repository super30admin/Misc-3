# S30 Problem #208 Reverse Nodes in k-Group
#LeetCode #25 https://leetcode.com/problems/reverse-nodes-in-k-group/description/

# Author : Akaash Trivedi
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# in the link count k nodes and reverse them
# use start and end to help with reverse. Initially take dummy as start node
# Reconnect the pointer after reversing in reverse funtion and return the start for next reverse
# time complexity: O(n)
# space complexity: O(1)

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(-1)
        dummy.next = head
        start = dummy  # start of node to be reversed
        curr = dummy

        count = 0

        while curr.next is not None:
            count += 1
            curr = curr.next
            if (count % k) == 0:
                start = self.reverse(start, curr.next)  # here curr.next would be end, cause curr is at kth node
                curr = start  # because current will be at 3 for k=3
        return dummy.next

    def reverse(self, start, end):
        prev = start
        curr = start.next
        fast = curr.next

        while fast is not end:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next

        curr.next = prev
        toReturn = start.next  # this is the next new start
        start.next.next = end  # point the 1st node to end
        start.next = curr  # point the last node in list to curr (is at reversed end)
        return toReturn
