class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] leftToRight = new int[n];
        int[] rightToLeft = new int[n];

        int prod = 1;
        for(int i=0 ; i<n ; i++) {
            prod *= nums[i];
            leftToRight[i] = prod;
        }

        prod = 1;
        for(int i=n-1 ; i>=0 ; i--) {
            prod *= nums[i];
            rightToLeft[i] = prod;
        }

        int[] output = new int[n];

        for(int i=0 ; i<n ; i++) {
            prod = 1;

            if(i-1 >= 0) prod *= leftToRight[i-1];

            if(i+1 < n) prod *= rightToLeft[i+1];

            output[i] = prod;
        }

        return output;
    }
}  
