public class Solution {
    // SC => O(nlog(high - low))
    // TC => O(1)
    public int ShipWithinDays(int[] weights, int days) {
        if(weights == null || weights.Length == 0){
            return 0;
        }

        int low = 0; 
        int high = 0;

        foreach(var w in weights){
            low = Math.Max(low, w);
            high += w;
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            int d = 1;
            int wt = 0;
            for(int i = 0; i< weights.Length; i++){
                if(weights[i] + wt <= mid){
                    wt += weights[i];
                }
                else{
                    d++;
                    wt = weights[i];
                }
            }
            if(d <= days){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}