class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        # T: O(n × log(sum(weights) - max(weights))), S: O(1)
        def can_ship(capacity: int) -> bool:
            total, required_days = 0, 1
            for weight in weights:
                if total + weight > capacity:
                    required_days += 1
                    total = 0
                total += weight
            return required_days <= days

        left, right = max(weights), sum(weights)
        while left < right:
            mid = (left + right) // 2
            if can_ship(mid):
                right = mid
            else:
                left = mid + 1
        return left
