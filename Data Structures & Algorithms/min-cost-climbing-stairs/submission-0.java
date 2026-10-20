class Solution {
    private int solve(int idx, int n, int[] cost, int[] dp) {
        if(idx > n) return 0;

        if(dp[idx] != -1) return dp[idx];

        int takeOne = solve(idx+1, n, cost, dp);
        int takeTwo = solve(idx+2, n, cost, dp);

        int res =  Math.min(takeOne, takeTwo);
        if(idx > 0) res += cost[idx-1];

        return dp[idx] = res; 
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        int res = solve(0, n, cost, dp);

        return res;
    }
}
