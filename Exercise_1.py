# S30 Problem #207 Capacity To Ship Packages Within D Days
#LeetCode #1011 https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

# Author : Akaash Trivedi
# Time Complexity : O(n * log(high-low))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# Find max of all the weights (low) and sum of all the weights (high)
# do binary search to find the capacity in between these weights
# calulate number of days at each mid capacity
# TC: TC: O(n * log(high-low))

class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        low = max(weights)
        high = sum(weights)

        # binary search to find the capacity
        while low <= high:
            mid = low + (high - low) // 2
            # number of days at this capacity
            currDays = 1
            currWt = 0  # current weight 
            for i in range(len(weights)):
                # if weight is more than capacity increase day count
                if currWt + weights[i] > mid:
                    currDays += 1
                    currWt = 0
                # keep increasing cuurent weight
                currWt += weights[i]
            if currDays <= days:
                high = mid - 1
            else:
                low = mid + 1
        return low
