class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        cur=head
        
        for i in range(k):
            if not cur:
                return head
            cur=cur.next       
        
        prev=None
        cur=head        
        print(cur.val)
        for i in range(k):
            nxt=cur.next
            cur.next=prev
            prev=cur
            cur=nxt
        
        
        head.next=self.reverseKGroup(cur,k) 
        return prev
           
        
