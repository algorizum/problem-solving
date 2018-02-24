class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int n = matrix.length, m = matrix[0].length, i, j;
        for (i = 0; i < n; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][m - 1]) {
                if (Arrays.binarySearch(matrix[i], target) > - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
