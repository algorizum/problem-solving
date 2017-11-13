## Refer To Solution


class Solution(object):
    def pacificAtlantic(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        height, width = len(matrix), len(matrix[0])
        pacific = set([(0, i) for i in range(width)]).union(set([(i, 0) for i in range(height)]))
        atlantic = set([(height - 1, i) for i in range(width)]).union([(i, width - 1) for i in range(height)])
        pacific_to_atlantic = [[False for _ in range(width)] for _ in range(height)]
        atlantic_to_pacific = [[False for _ in range(width)] for _ in range(height)]

        for y_pos, x_pos in pacific:
            pacific_to_atlantic[y_pos][x_pos] = True

        for y_pos, x_pos in atlantic:
            atlantic_to_pacific[y_pos][x_pos] = True

        self.bfs(pacific, matrix, pacific_to_atlantic)
        self.bfs(atlantic, matrix, atlantic_to_pacific)

        answer = []
        for i in range(height):
            for j in range(width):
                if pacific_to_atlantic[i][j] and atlantic_to_pacific[i][j]:
                    answer.append([i, j])
        return answer

    def bfs(self, queue, matrix, board):
        height, width = len(board), len(board[0])
        while queue:
            y_pos, x_pos = queue.pop()
            board[y_pos][x_pos] = True
            for x_offset, y_offset in [(0, 1), (1, 0), (-1, 0), (0, -1)]:
                if 0 < y_pos + y_offset < height and 0 < x_pos + x_offset < width and not board[y_pos + y_offset][
                            x_pos + x_offset] and matrix[y_pos][x_offset] >= matrix[y_pos + y_offset][x_pos + x_offset]:
                    queue.add((y_pos + y_offset, x_pos + x_offset))


if __name__ == '__main__':
    solution = Solution()
    print solution.pacificAtlantic(
            [[1, 2, 2, 3, 5], [3, 2, 3, 4, 4], [2, 4, 5, 3, 1], [6, 7, 1, 4, 5], [5, 1, 1, 2, 4]])
