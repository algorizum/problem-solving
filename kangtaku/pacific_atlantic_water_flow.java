class Solution {
    final static int[][] arrows = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int n, m;
    boolean[][][] map;
    int[][] matrix;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        ArrayList<int[]> ans = new ArrayList<>();
        n = matrix.length;
        if (n == 0) return ans;
        m = matrix[0].length;
        this.matrix = matrix;
        map = new boolean[2][n][m];
        int i, j;
        for (i = 0; i < n; i++) {
            check(i, 0, 0, -1);
            check(i, m - 1, 1, -1);
        }
        for (i = 0; i < m; i++) {
            check(0, i, 0, -1);
            check(n - 1,  i, 1, -1);
        }
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (map[0][i][j] && map[1][i][j]) {
                    ans.add(new int[]{i, j});
                }
            }
        }
        return ans;
    }
    
    public void check(int x, int y, int isPac, int before) {
        if (x == -1 || y == -1 || x == n || y == m || map[isPac][x][y] || before > matrix[x][y]) return;
        map[isPac][x][y] = true;
        for (int[] arrow : arrows) {
            check(x + arrow[0], y + arrow[1], isPac, matrix[x][y]);
        }
    }
    
    class Pair {
        int x, y;
    }
}
