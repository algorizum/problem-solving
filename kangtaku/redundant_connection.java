class Solution {
    int[] parent;
    int[] size;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length, i;
        parent = new int[1001];
        size = new int[1001];
        for (i = 0; i < 1001; i++) {
            parent[i] = i;
        }
        int[] ans = new int[2];
        for (i = 0; i < n; i++) {
            if (!merge(edges[i][1], edges[i][0])) {
                ans = edges[i];
            }
        }
        return ans;
    }

    public boolean merge(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        parent[a] = b;
        size[b] += size[a];
        return true;
    }

    public int find(int node) {
        if (parent[node] == node) return node;
        else return parent[node] = find(parent[node]);
    }
}