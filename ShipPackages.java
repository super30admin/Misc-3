// THis solution uses a binary search approach of checking from min to max of possible weights that can be shipped
// Min is the maximum number in the array
// Max is the total sum of numbers in the array
// While doing the binary search over this range, we calculate days possible for a given weight i.e, at mid. If the days are more than needed, we reduce max to mid-1 otherwise min to mid+1
// The closing condition is when the whole range is checked and it breaks to get the min value
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0;
        int max = 0;

        for(int weight:weights) {
            min=Math.max(min, weight);
            max+=weight;
        }
        
        while(min<=max) {
            int mid = min+(max-min)/2;
            int daysForWeight = getDays(weights, mid);

            if(daysForWeight>days) {
                min=mid+1;
            } else if(daysForWeight<=days) {
                max=mid-1;
            }
        }
        return min;
    }

    private int getDays(int[] weights, int val) {
        int days = 0, count = 0;
        for(int i:weights) {
            if(count+i <= val) {
                count+=i;
            } else {
                days++;
                count=i;
            }
        }
        return days+1;
    }
}
