//problem1
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0;
        int right=0;
        for(int i=0;i<weights.length;i++){
            left=Math.max(left,weights[i]);
            right+=weights[i];
        }
        while(left<right){
            int currcap=left+(right-left)/2;
            int cnt=1,sum=0;
            for(int i=0;i<weights.length;i++){
                sum+=weights[i];
                if(sum>currcap){
                    cnt++;
                    sum=weights[i];
                }
            }
            if(cnt<=days){
                right=currcap;
            }else{
                left=currcap+1;
            }
        }
        return left;
    }
}
//problem2
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int count=0;
        ListNode curr=head;
        ListNode start=dummy;
        while(curr!=null){
            curr=curr.next;
            count++;
            if(count%k==0){
                start=reverse(start,curr);
            }
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode start,ListNode end){
        ListNode prev=null;
        ListNode curr=start.next;
        ListNode first=start.next;
        while(curr!=end){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        start.next=prev;
        first.next=end;
         return first;
    }
}
