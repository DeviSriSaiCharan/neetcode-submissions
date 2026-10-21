class Solution {
    private int solve(int idx, int n, int[] cost, int[] dp) {
        if(idx >= n) return 0;

        if(dp[idx] != -1) return dp[idx];

        int takeOne = solve(idx+1, n, cost, dp);
        int takeTwo = solve(idx+2, n, cost, dp);

        int res =  Math.min(takeOne, takeTwo) + cost[idx];

        return dp[idx] = res; 
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n+2];
        Arrays.fill(dp, -1);

        // int res1 = solve(0, n, cost, dp);
        // int res2 = solve(1, n, cost, dp);

        // return Math.min(res1, res2);

        dp[n+1] = 0;
        dp[n] = 0;

        for(int i=n-1 ; i>=0 ; i--) {
            dp[i] = Math.min(dp[i+1], dp[i+2]) + cost[i];
        }

        return Math.min(dp[0], dp[1]);
    }
}
