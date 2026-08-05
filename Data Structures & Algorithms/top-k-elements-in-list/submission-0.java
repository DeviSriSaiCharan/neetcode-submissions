class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            int key = it.getKey(), val = it.getValue();
            ArrayList<Integer> p = new ArrayList<>();
            p.add(key);
            p.add(val);
            arr.add(p);
        }

        Collections.sort(arr, (a, b) -> {
            return b.get(1) - a.get(1);
        });

        int i = 0;
        int[] res = new int[k];

        for(ArrayList<Integer> p : arr) {
            if(i < k) res[i++] = p.get(0);
        }

        return res;
    }
}
