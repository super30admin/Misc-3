from typing import List
class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        high = sum(weights)
        low = max(weights)
        while low<=high:
            currwt = 0
            d = 1
            midwt = (high+low)//2
            for wt in weights:
                currwt+=wt
                if currwt>midwt:
                    d+=1
                    currwt = wt
            if d<=days:
                high = midwt-1
            else:
                low = midwt+1
        return low
                

        