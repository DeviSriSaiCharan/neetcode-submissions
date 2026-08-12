class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        HashSet<List<Integer>> set = new HashSet<>();

        for(int i=0 ; i<n ; i++) {
            int sum = nums[i];
            int target = -sum;
            int left = i+1, right = n-1;

            while(left < right) {
                int total = nums[left] + nums[right];

                if(target == total) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);

                    Collections.sort(triplet);

                    set.add(triplet);

                    left++;
                    right--;
                }

                if(target > total) left++;

                if(target < total) right--;
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for(List<Integer> t : set) {
            res.add(t);
        }

        return res;
    }
}
