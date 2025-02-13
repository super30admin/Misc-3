// Time Complexity: O(log [min, max) n
public class PackageCapacity {
    public int shipPackage( int [] weights, int days){
        if( weights == null || weights.length == 0) return 0;
        int low =0, high = 0;
        for( int weight: weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        while(low <= high){
            int mid = low + (high - low )/2;
            int currDays = 1;
            int currSum = 0;

            for(int i =0; i< weights.length;i++){
                if(currSum + weights[i] > mid){
                    currDays++; // increment the days
                    currSum = 0; //  Reset to new day
                }
                currSum = currSum + weights[i];

            }
                if(currDays > days){
                    low = mid +1; // reduce the search window
                } else {
                    high = mid -1; // expand the search window
                }
            }
            return low;
        }

        public static void main( String [] args){
        PackageCapacity solution = new PackageCapacity();
        int [] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        int result = solution.shipPackage(weights, days);

        System.out.println(result);

    }
}
