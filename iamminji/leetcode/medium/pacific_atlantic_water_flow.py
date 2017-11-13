# 417. Pacific Atlantic Water Flow
# https://leetcode.com/problems/pacific-atlantic-water-flow/description/

from collections import deque

path = [[0, 1], [1, 0], [-1, 0], [0, -1]]


class Solution(object):
    def bfs(self, matrix, ocean, flow, w, h):

        visited = dict()

        while len(ocean) > 0:
            coordinates = ocean.popleft()
            i, j = coordinates[0], coordinates[1]

            visited[(i, j)] = True

            for p in path:

                if (i + p[0], j + p[1]) in visited:
                    continue

                if j + p[1] > w - 1 or i + p[0] > h - 1 or i + p[0] < 0 or j + p[1] < 0:
                    continue

                if matrix[i][j] <= matrix[i + p[0]][j + p[1]]:
                    flow[i + p[0]][j + p[1]] = flow[i][j]
                    ocean.append([i + p[0], j + p[1]])
        return flow

    def pacificAtlantic(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        if not matrix:
            return []
        if not matrix[0]:
            return []

        width = len(matrix[0])
        height = len(matrix)

        p_path = deque()
        a_path = deque()

        pflow = [[0 for _ in range(width)] for _ in range(height)]
        aflow = [[0 for _ in range(width)] for _ in range(height)]

        for jdx in range(width):
            pflow[0][jdx] = 1
            aflow[height - 1][jdx] = 1
            p_path.append([0, jdx])
            a_path.append([height - 1, jdx])

        for idx in range(height):
            pflow[idx][0] = 1
            aflow[idx][width - 1] = 1
            p_path.append([idx, 0])
            a_path.append([idx, width - 1])

        new_p_flow = self.bfs(matrix, p_path, pflow, width, height)
        new_a_flow = self.bfs(matrix, a_path, aflow, width, height)

        result = list()
        for idx in range(height):
            for jdx in range(width):
                if new_p_flow[idx][jdx] == new_a_flow[idx][jdx] == 1:
                    result.append([idx, jdx])
        return result


if __name__ == "__main__":
    sol = Solution()
    print sol.pacificAtlantic([[1, 2, 2, 3, 5], [3, 2, 3, 4, 4], [2, 4, 5, 3, 1], [6, 7, 1, 4, 5], [5, 1, 1, 2, 4]])
