# problem 2 


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy_node = ListNode(-1)
        dummy_node.next = head 
        start = dummy_node 
        curr = head 
        count = 0   

        while curr is not None and count < k:
            curr = curr.next
            count += 1

        if count == k:
            reversedHead = self.reverse(head, curr)
            head.next = self.reverseKGroup(curr, k)
            return reversedHead

        return head


        return head 

    def reverse(self,start,end):
        prev = None 
        curr = start 
        while curr!=end:
            temp = curr.next
            curr.next = prev 
            prev = curr 
            curr = temp
        return prev