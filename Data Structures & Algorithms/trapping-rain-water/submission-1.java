class Solution {
    private int findMax(int left, int right, int[] height) {
        int maxi = 0;

        for(int i=left ; i<right ; i++) maxi = Math.max(maxi, height[i]);

        return maxi;
    }

    public int trap(int[] height) {
        int n = height.length;

        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        int maxi = 0;
        for(int i=0 ; i<n ; i++) {
            maxi = Math.max(maxi, height[i]);
            prefixMax[i] = maxi;
        } 

        maxi = 0;
        for(int i=n-1 ; i>=0 ; i--) {
            maxi = Math.max(maxi, height[i]);
            suffixMax[i] = maxi;
        }

        int totalWater = 0;
        for(int i=1 ; i<n-1 ; i++) {
            int leftMax = prefixMax[i];
            int rightMax = suffixMax[i];

            int minHeight = Math.min(leftMax, rightMax);
            int rem = minHeight - height[i];

            if(rem > 0) {
                totalWater += rem;
            }
        }

        return totalWater;
    }
}
