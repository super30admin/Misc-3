# Problem 1: Capacity to ship packages in d days (https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/)
#Time Complexity: O(n * log(sum(weights) - max(weights))),Binary search range is (sum(weights) - max(weights)), so it runs log(sum-max) times. Each round scans all n weights once to simulate the days needed.
#Space Complexity: O(1),Only a few counters are used, no extra data structures.
#Approach: 
#Binary search on the answer.
#The answer (ship capacity) lies between max(weights) (must fit the heaviest single package) and sum(weights) (ship everything in one day).
#As capacity increases, days needed to ship never increases (monotonic),so binary search applies.
#For each candidate capacity (mid), simulate loading the ship day by day.
#If it finishes within the allowed days, try a smaller capacity.
#If it takes too many days, try a bigger capacity.
#The smallest capacity that still finishes in time is the answer.

class Solution:
    def shipWithinDays(self, weights: list[int], days: int) -> int:
        
        low = max(weights)   # smallest possible capacity: must fit the heaviest package
        high = sum(weights)  # largest possible capacity: ship everything in one day

        while low <= high:
            mid = (low + high) // 2  # candidate capacity to test

            current_weight = 0  # weight loaded on the current day
            current_days = 1    # day counter, starts at day 1

            for i in weights:
                current_weight += i  # try adding this package to today's load

                if current_weight > mid:
                    # package doesn't fit today, start a new day with it
                    current_days += 1
                    current_weight = i

            if current_days <= days:
                # mid works, try to shrink capacity further
                high = mid - 1
            else:
                # mid too small, need more capacity
                low = mid + 1

        return low  # smallest capacity that ships everything within 'days'