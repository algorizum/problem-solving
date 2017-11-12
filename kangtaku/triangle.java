class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(), i, j;
        int[][] d = new int[2][n];
        d[0][0] = triangle.get(0).get(0);
        for (i = 1; i < n; i++) {
            for (j = 0; j <= i; j++) {
                int min = Integer.MAX_VALUE, now = triangle.get(i).get(j);
                if (j > 0 && min > now + d[(i - 1) % 2][j - 1]) {
                    min = now + d[(i - 1) % 2][j - 1];
                }
                if (j < i && min > now + d[(i - 1) % 2][j]) {
                    min = now + d[(i - 1) % 2][j];
                }
                d[i % 2][j] = min;
                //System.out.print(min + " ");
            }
            //System.out.println();
        }
        int ans = Integer.MAX_VALUE;
        for (i = 0; i < n; i++) {
            ans = Math.min(ans, d[(n - 1) % 2][i]);
        }
        return ans;
    }
}
