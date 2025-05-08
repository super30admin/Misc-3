# Problem 1 : Capacity To Ship Packages Within D Days
# Time Complexity : O(n * log(sum(weights))) where n is the length of the weights
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach

from typing import List
class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        # define low and high variables which will store the low value and high value
        low = 0
        high = 0
        # loop through weights list
        for wt in weights:
            # get the maximum value between low and weight wt
            low = max(low, wt)
            # add weight to high to get the value for high
            high += wt

        # loop till low is less than or equal to high
        while low <= high:
            # get the middle value between low and high
            middle = low + (high - low) // 2
            # define the currentDays and set to 1 which will calculate number of days for the middle weight
            currentDays = 1 
            # define currentSum which will store the current sum of weight
            currentSum = 0
            # loop from 0 to length of weights
            for i in range(len(weights)):
                # check if the sum of current sum and weight of ith package is greater than middle value
                if currentSum + weights[i] > middle:
                    # if it is then reset the current sum to 0 and increment the value of currentDays
                    currentSum = 0
                    currentDays += 1
                # add the weight of ith package to the current sum
                currentSum += weights[i]
            # check if the value of currentDays is less than or equal to days then set high to middle - 1
            if currentDays <= days:
                high = middle - 1
            else:
                # else set low to middle + 1
                low = middle + 1
        # return low  
        return low
