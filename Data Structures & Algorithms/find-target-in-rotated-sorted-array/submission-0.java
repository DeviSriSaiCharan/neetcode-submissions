class Solution {
    private int findPivot(int[] nums) {
        int n = nums.length;

        int left = 0, right = n-1;

        while(left < right) {
            int mid = (left + right) / 2;

            if(nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }

        return left;
    }

    private int BS(int l, int r, int[] nums, int target) {

        while(l <= r) {
            int mid = (l + r) / 2;

            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        
        int pivot = findPivot(nums);

        if(target >= nums[0] && pivot > 0 && target <= nums[pivot-1]) return BS(0, pivot - 1, nums, target);

        return BS(pivot, n-1, nums, target);
    }
}
