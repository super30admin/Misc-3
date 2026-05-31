# problem 1 


class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        low = max(weights)
        high = sum(weights)

        while low <= high:
            mid = (low+high) // 2 
            curr_weight = 0
            curr_days = 1

            for wt in weights:
                curr_weight += wt 
                if curr_weight > mid:
                    curr_days += 1
                    curr_weight = wt 

            if curr_days <= days:
                high = mid-1
            else:
                low = mid + 1

        return low