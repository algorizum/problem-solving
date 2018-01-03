class Solution {
public:
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int result = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[i].size(); j++) {
                result = max(result, fill(grid, i, j));
            }
        }
        return result;
    }
private:
    int fill(vector<vector<int>>& grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.size() || j >= grid[i].size() || grid[i][j] == 0) return 0;
        int result = grid[i][j];
        grid[i][j] = 0;
        return result + fill(grid, i + 1, j) + fill(grid, i - 1, j) + fill(grid, i, j + 1) + fill(grid, i, j - 1);
    }
}; 
