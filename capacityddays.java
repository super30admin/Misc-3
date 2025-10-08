//TC: O(n log S): binary search over capacity range S≈sum(weights) with an O(n) feasibility scan per step.
//SC: O(1): constant extra variables.

//Set capacity bounds: low = max(weights), high = sum(weights).
//Binary search cap=mid; simulate loading left→right: accumulate, and when currWt>cap, increment currDays and reset currWt to current wt.
//If needed days <= target, shrink high; else raise low; final answer is low.

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for(int num : weights){
            low = Math.max(low, num); 
            high += num;             
        }

        while(low <= high){
            int mid = low + (high - low)/2;

            int currWt = 0;
            int currDays = 1;

            for(int wt : weights){
                currWt += wt;

                if(currWt > mid){
                    currDays++;
                    currWt = wt;
                }
            }

            if(currDays <= days){
                high = mid - 1; 
            }else{
                low = mid + 1;  
            }
        }

        return low; 
    }
}
