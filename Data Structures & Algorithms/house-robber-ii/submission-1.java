class Solution {
    private int solve(int idx, int n, int[] nums) {
        if(idx >= n) return 0;

        int take = solve(idx+2, n, nums) + nums[idx];
        int notTake = solve(idx+1, n, nums);

        return Math.max(take, notTake);
    }
    
    private int tabulation(int start, int end, int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        
        int[] dp = new int[n+2];
        
        for(int i=end ; i>=start ; i--) {
            int take = dp[i+2] + nums[i];
            int notTake = dp[i+1];

            dp[i] = Math.max(take, notTake);
        }

        return dp[start];
    }

    public int rob(int[] nums) {
        int n = nums.length;

        int res1 = tabulation(0, n-2, nums);
        int res2 = tabulation(1, n-1, nums);

        return Math.max(res1, res2);
    }
}
