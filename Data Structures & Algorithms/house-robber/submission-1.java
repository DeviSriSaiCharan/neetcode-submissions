class Solution {
    private int solve(int idx, int[] nums) {
        if(idx < 0) return 0;
        if(idx == 0) return nums[0];

        int rob = solve(idx-2, nums) + nums[idx];
        int dont = solve(idx-1, nums);

        return Math.max(rob, dont);
    }

    public int rob(int[] nums) {
        int n = nums.length;

        // int res = solve(n-1, nums);

        // return res;

        int prev = nums[0], last = 0;
        
        for(int i=2 ; i<=n ; i++) {
            int rob = last + nums[i-1];
            int dont = prev;

            last = prev;
            prev = Math.max(rob, dont);
        }

        return prev;
    }
}
