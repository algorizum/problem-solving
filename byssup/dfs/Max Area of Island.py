class Solution(object):
    def maxAreaOfIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        size = 0
        for i, row in enumerate(grid):
            for j, col in enumerate(row):
                if col == 1:
                    size = max(size, self.get_island_size(j, i, grid))
        return size

    def get_island_size(self, x_pos, y_pos, grid):
        grid[y_pos][x_pos] = -1
        size = 1
        queue = set([(x_pos, y_pos)])
        width, height = len(grid[0]), len(grid)
        while queue:
            x_pos, y_pos = queue.pop()
            for x_move, y_move in [(-1, 0), (0, 1), (1, 0), (0, -1)]:
                if 0 <= x_pos + x_move < width and 0 <= y_pos + y_move < height and grid[y_pos + y_move][
                            x_pos + x_move] == 1:
                    grid[y_pos + y_move][x_pos + x_move] = -1
                    queue.add((x_pos + x_move, y_pos + y_move))
                    size += 1
        return size
