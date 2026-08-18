class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;

        int left = 0, right = (rows * cols) - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            int r = mid / cols;
            int c = mid % cols;

            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] > target) right = mid - 1;
            else left = mid + 1;
        }

        return false; 
    }
}
