// Time Complexity : O(n log(range))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// the range of capacities that are possible is lowest weight(n days) to sum of all weights(1day)
// we binary search in this range of solutions to get the minimum possible capacity to complete in k days
// For every solution we calculate days required and try to go in minimum possible direction

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        while (low <= high) {
            int capacity = low + (high - low) / 2;
            int d = 1;
            int currW = 0;

            for (int i = 0; i < weights.length; i++) {
                if (currW + weights[i] > capacity) {
                    d++;
                    currW = 0;
                }
                currW += weights[i];
            }

            if (d > days)
                low = capacity + 1;
            else
                high = capacity - 1;
        }

        return low;
    }
}