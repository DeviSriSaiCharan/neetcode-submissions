class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // Skiping duplicates
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            if (nums[i] > 0)
                break;

            int sum = nums[i];
            int target = -sum;
            int left = i + 1, right = n - 1;

            while (left < right) {
                int total = nums[left] + nums[right];

                if (target == total) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);

                    res.add(triplet);

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }

                if (target > total)
                    left++;

                if (target < total)
                    right--;
            }
        }

        return res;
    }
}
