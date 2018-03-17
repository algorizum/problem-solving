class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        int n = equations.length, m = queries.length, i, j, k, idx = 0;
        int x, y;
        double[] ans = new double[m];
        Map<String, Integer> mp = new HashMap<>();
        double[][] graph = new double[100][100];
        for (i = 0; i < n; i++) {
            String[] equ = equations[i];
            if (!mp.containsKey(equ[0])) {
                mp.put(equ[0], idx++);
            }
            if (!mp.containsKey(equ[1])) {
                mp.put(equ[1], idx++);
            }
            x = mp.get(equ[0]);
            y = mp.get(equ[1]);
            graph[x][y] = values[i];
            graph[y][x] = 1.0 / values[i];
        }
        
        for (i = 0; i < idx; i++) {
            for (j = 0; j < idx; j++) {
                for (k = 0; k < idx; k++) {
                    if (k == i || k == j) continue;
                    if (graph[i][k] != 0 && graph[k][j] != 0) {
                        graph[i][j] = graph[i][k] * graph[k][j];
                    }
                }
            }
        }
        
        for (i = 0; i < m; i++) {
            String[] query = queries[i];
            x = -1;
            y = -1;
            if (mp.containsKey(query[0])) {
                x = mp.get(query[0]);
            }
            if (mp.containsKey(query[1])) {
                y = mp.get(query[1]);
            }
            if (x == -1 || y == -1) {
                ans[i] = -1;
                continue;
            }
            if (graph[x][y] == 0) ans[i] = -1;
            else ans[i] = graph[x][y];
        }
        return ans;
    }
}

class Pair {
    String v;
    double k;
}
