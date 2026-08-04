class Pair {}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        int[] res = new int[2];

        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int i=0 ; i<n ; i++) {
            int diff = target - nums[i];

            if(mpp.containsKey(diff)) {
                res[0] = mpp.get(diff);
                res[1] = i;
                break;
            }

            mpp.put(nums[i], i);
        }

        return res;
    }
}
