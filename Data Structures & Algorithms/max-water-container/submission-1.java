class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int area = 0;

        int left = 0, right = n-1;

        while(left <= right) {
            int a = (right - left) * Math.min(heights[right], heights[left]);

            area = Math.max(area, a);

            if(heights[left] > heights[right]) {
                right--;
            } else {
                left ++;
            }
        }

        return area;
    }
}
