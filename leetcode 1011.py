"""
Time Complexity: O(n * log(high - low))
Space Complexity: O(1)
"""
class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        low = max(weights)
        high = sum(weights)

        while low <= high:
            mid = (low + high) // 2

            currWt = 0
            currDays = 1

            for wt in weights:
                currWt += wt
                if currWt > mid:
                    currDays += 1
                    currWt = wt

            if currDays <= days:
                high = mid - 1
            else:
                low = mid + 1

        return low