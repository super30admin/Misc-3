# Time Complexity : O(k*logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        min_cap = max(weights)
        max_cap = sum(weights)

        l,r = min_cap, max_cap

        while l < r:
            mid = l + (r-l)//2
            cur_days = self.calc_days(mid, weights)

            if cur_days < days:
                r = mid
            
            else:
                l = mid + 1
        
        return l
    
    def calc_days(self, mid, weights):
        days = 0
        cur_cap = 0
        for w in weights:
            cur_cap += w
            if cur_cap > mid:
                days += 1
                cur_cap = w
        
        return days