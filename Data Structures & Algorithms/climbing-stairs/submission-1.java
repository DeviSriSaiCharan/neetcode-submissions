class Solution {
    private int solve(int n, int[] dp) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        
        if(dp[n] != -1) return dp[n];

        return dp[n] = solve(n-1, dp) + solve(n-2, dp);
    }

    public int climbStairs(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        // int res = solve(n, dp);

        // return res;
        dp[0] = 1;
        for(int i=1 ; i<=n ; i++) {
            int twoStep = 0;
            if(i-2 >= 0) twoStep = dp[i-2];

            dp[i] = dp[i-1] + twoStep;
        }

        return dp[n];
    }
}
