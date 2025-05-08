# Time Complexity : O(n)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(-99)
        tail = dummy

        start, end = head, head
        while end:
            for i in range(k-1):
                if end:
                    end = end.next
                else:
                    break
            if not end:
                break
            next_start = end.next
            end.next = None
            tail.next = self.rev(start)
            for i in range(k):
                tail = tail.next
            start,end = next_start,next_start
        
        if start:
            tail.next = start

        return dummy.next
    
    def rev(self, head):
        if not head or not head.next:
            return head
        
        new_head = self.rev(head.next)
        head.next.next = head
        head.next = None
        return new_head