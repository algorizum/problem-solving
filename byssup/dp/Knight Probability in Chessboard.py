class Solution(object):
    def knightProbability(self, N, K, r, c):
        """
        :type N: int
        :type K: int
        :type r: int
        :type c: int
        :rtype: float
        """
        dp = []
        for _ in range(N + 1):
            dp.append([0 for _ in range(N + 1)])
        dp[r][c] = 1
        for _ in range(K):
            temp = []
            for _ in range(N):
                temp.append([0 for _ in range(N)])
            for i, row in enumerate(dp):
                for j, col in enumerate(row):
                    for x_move, y_move in [(1, 2), (1, -2), (-1, 2), (-1, -2),
                                           (2, 1), (2, -1), (-2, 1), (-2, -1)]:
                        if 0 <= j + x_move < N and 0 <= i + y_move < N:
                            temp[i + y_move][j + x_move] += dp[i][j]
            dp = temp
        return sum([sum(row) for row in dp]) / float(pow(8, K))
