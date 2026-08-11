class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if(n == 0) return 0;

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int len = 1, maxLen = 1;

        for(int i=1 ; i<n ; i++) {
            if(nums[i] == nums[i-1]) continue;
            if(nums[i] == nums[i-1] + 1) {
                len++;
            } else {
                maxLen = Math.max(maxLen, len);
                len = 1;
            }
        }

        maxLen = Math.max(maxLen, len);

        return maxLen;
    }
}
