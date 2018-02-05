class Solution {
    final static int MAX = 99999999;
    public int findRotateSteps(String ring, String key) {
        int n = ring.length(), i, j, m = key.length(), k;
        int[][] d = new int[2][n];
        Arrays.fill(d[1], MAX);
        d[1][0] = 0;
        for (i = 0; i < m; i++) {
            char t = key.charAt(i);
            Arrays.fill(d[i % 2], MAX);
            for (j = 0; j < n; j++) {
                if (d[(i + 1) % 2][j] != MAX) {
                    for (k = 0; k < n; k++) {
                        int left = (j - k + n) % n;
                        int right = (j + k) % n;
                        if (t == ring.charAt(left)) {
                            d[i % 2][left] = Math.min(d[i % 2][left], d[(i + 1) % 2][j] + k + 1);
                        }
                        if (t == ring.charAt(right)) {
                            d[i % 2][right] = Math.min(d[i % 2][right], d[(i + 1) % 2][j] + k + 1);
                        }
                    }
                }
            }
            
        }
        int ans = MAX;
        for (i = 0; i < n; i++) {
            ans = Math.min(ans, d[(m + 1) % 2][i]);
        }
        
        return ans;
    }
}
