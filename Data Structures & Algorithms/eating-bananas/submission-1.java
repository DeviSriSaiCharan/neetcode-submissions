class Solution {
    private int timeToEat(int k, int[] piles) {
        int time = 0;

        for(int pile : piles) {
            time += Math.ceil(pile / (double)k);
        }

        return time;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int left = 1, right = 0;
        for(int pile : piles) right = Math.max(pile, right);

        int ans = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(timeToEat(mid, piles) <= h) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }

        return ans;
    }
}
