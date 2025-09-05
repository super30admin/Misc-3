from typing import List, Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(-1)
        dummy.next = head
        start = dummy
        curr = head 
        count = 0
        def reverse(start, end):
            prev = None
            curr = start.next
            first = start.next
            while curr!=end:
                temp =curr.next
                curr.next = prev
                prev = curr
                curr = temp
            first.next = end
            start.next = prev
            return first

        while curr:
            curr = curr.next
            count+=1
            if count%k == 0:
                start = reverse(start,curr)
        return dummy.next