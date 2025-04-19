
public class Sample{
/********************PROBLEM-1*****************/
//TC:0(Nlog(high-low))
//SC:0(N)
class Solution {
    int[] weights;
    public int shipWithinDays(int[] weights, int days) {
        if(weights==null || weights.length==0){
            return 0;
        }
        this.weights=weights;
        int max=0,sum=0,calcDays=0;
        for(int weight:weights){
            max=Math.max(max,weight);
            sum+=weight;
        }

        int low=max,high=sum;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(calcDays(mid)>days){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }


    private int calcDays(int max){
        int sumCalc=0,days=0;
        for(int weight:weights){
            sumCalc+=weight;
            if(sumCalc>max){
                days++;
                sumCalc=weight;
            }
        }
        int remainder=(sumCalc>max)?0:1;
        return days+remainder;
    }
}
/********************PROBLEM-2*****************/

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
    //TC:0(N)
    //SC:0(1)
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head==null || k<=1){
                return head;
            }

            ListNode dummy=new ListNode(-1);
            dummy.next=head;

            int count=0;
            ListNode begin=dummy;
            while(head!=null){
                count++;
                if(count%k==0){
                    begin=reverse(begin,head.next);
                    head=begin;
                }
                head=head.next;
            }

            return dummy.next;
        }

        private ListNode reverse(ListNode begin,ListNode end){
            ListNode first=begin.next;
            ListNode curr=begin.next;
            ListNode prev=null;
            ListNode fast=curr.next;
            while(fast!=end){
                curr.next=prev;
                prev=curr;
                curr=fast;
                fast=fast.next;
            }
            curr.next=prev;
            first.next=end;
            begin.next=curr;

            return first;
        }
    }
}