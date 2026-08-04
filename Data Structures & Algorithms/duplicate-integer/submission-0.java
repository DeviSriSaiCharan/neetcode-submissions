class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Boolean> mpp = new HashMap<>();

        for(int num : nums) {
            if(!mpp.containsKey(num)) mpp.put(num, true);
            else return true;
        }

        return false;
    }
}