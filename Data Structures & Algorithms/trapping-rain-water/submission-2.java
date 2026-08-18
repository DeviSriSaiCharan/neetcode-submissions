class Solution {
    private int findMax(int left, int right, int[] height) {
        int maxi = 0;

        for(int i=left ; i<right ; i++) maxi = Math.max(maxi, height[i]);

        return maxi;
    }

    public int trap(int[] height) {
        int n = height.length;

        int leftMax = 0, rightMax = 0;

        int left = 0, right = n-1;

        int totalWater = 0;

        while(left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax < rightMax) {
                int rem = leftMax - height[left];
                totalWater += rem;
                left++;
            } else {
                int rem = rightMax - height[right];
                totalWater += rem;
                right--;
            }
        }

        return totalWater;
    }
}
