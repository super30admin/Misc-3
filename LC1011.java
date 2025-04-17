// TC = O(N log K)
// SC = O(1)
// where K is the sum of weights - the maximum weight
// and N is the number of weights

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int min = weights[0], max = 0;
        for (int w : weights) {
            max += w;
            min = Math.max(min, w);
        }
        while (min <= max) {
            int mid = (min + max) >> 1;
            int d = 1, wt = 0;
            for (int i = 0; i < n; i++) {
                if (wt + weights[i] <= mid)
                    wt += weights[i];
                else {
                    d++;
                    wt = weights[i];
                }
            }
            if (d > days)
                min = mid + 1;
            else
                max = mid - 1;
        }
        return min;
    }
}