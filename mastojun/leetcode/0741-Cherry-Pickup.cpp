class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
        if (grid.size() == 0) return 0;
        int N = grid.size();
        vector<vector<vector<int>>> dp(N, vector<vector<int>>(N, vector<int>(N, -1)));
        int result = maxPath(grid, dp, 0, 0, 0, 0);
        return result < 0 ? 0 : result;
    }
private:
    int maxPath(vector<vector<int>>& grid, vector<vector<vector<int>>>& cache, int x1, int y1, int x2, int y2) {
        if (x1 >= grid.size() || y1 >= grid[x1].size() || x2 >= grid.size() || y2 >= grid[x2].size()) return -987654321;
        if (grid[x1][y1] == -1 || grid[x2][y2] == -1) return -987654321;
        if (x1 == grid.size() - 1 && y1 == grid[x1].size() - 1 && x2 == grid.size() - 1 && y2 == grid[x2].size() - 1) return grid[x1][y1];
        int& ret = cache[x1][y1][x2];
        if (ret != -1) return ret;
        int org1 = grid[x1][y1];
        int org2 = grid[x2][y2];
        ret = grid[x1][y1];
        grid[x1][y1] = 0;
        ret += grid[x2][y2];
        grid[x2][y2] = 0;
        ret += max(max(maxPath(grid, cache, x1 + 1, y1, x2 + 1, y2), maxPath(grid, cache, x1, y1 + 1, x2 + 1, y2)),
                   max(maxPath(grid, cache, x1 + 1, y1, x2, y2 + 1), maxPath(grid, cache, x1, y1 + 1, x2, y2 + 1)));
        grid[x1][y1] = org1;
        grid[x2][y2] = org2;
        return ret;
    }
};
