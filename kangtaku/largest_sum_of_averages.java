class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int ans = 0, now = A[0], cnt = 1, n = A.length, i, k, j;
        double[][] d = new double[n][n];
        double[] sums = new double[n + 1];
        for (i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + A[i - 1];
        }
        d[0][0] = A[0];
        double sum = A[0];
        for (i = 1; i < n; i++) {
            sum += A[i];
            d[0][i] = sum / (i + 1);
        }
        for (k = 1; k < K; k++) {
            for (i = k; i < n; i++) {
                if (i == k) {
                    d[k][i] = d[k - 1][i - 1] + A[i];
                    continue;
                }
                double max = -1;
                for (j = k; j <= i; j++) {
                    // if (d[k][i] < )
                    max = Math.max(max, (sums[i + 1] - sums[j]) / (i + 1 - j) + d[k - 1][j - 1]);
                }
                d[k][i] = max;
            }
        }
        return d[K - 1][n - 1];
    }
}
