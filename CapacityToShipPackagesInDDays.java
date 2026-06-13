// Time Complexity : O(log(high-low) * n), where low = highest weight, high = sum of all the weights, n = length of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We use binary search to find the ideal weight between highest recorded weight and the total weight.For each
mid weight,we compute how many number of days would we require.If the computed days is less than the input days,
we adjust the high value, if not update low value and continue until low,high cross each other.Return low value
at last.
 */
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        for(int wt : weights) {
            low = Math.max(low, wt);
            high += wt;
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int currWeight = 0;
            int currDays = 1;

            for(int weight : weights) {
                currWeight += weight;
                if(currWeight > mid) {
                    currDays++;
                    currWeight = weight;
                }
            }

            if(currDays <= days) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}