class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int i, j, n = grid.length, m = grid[0].length, ans = 0;
        int[] row = new int[n], col = new int[m];
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                col[j] = Math.max(col[j], grid[i][j]);
                row[i] = Math.max(row[i], grid[i][j]);
            }
        }
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                ans += Math.min(row[i], col[j]) - grid[i][j];
            }
        }
        return ans;
    }
}
