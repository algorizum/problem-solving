# 657. Judge Route Circle
# https://leetcode.com/problems/judge-route-circle/description/


class Solution:
    def judgeCircle(self, moves):
        """
        :type moves: str
        :rtype: bool
        """

        start = [0, 0]
        jump = {'L': (0, -1), 'R': (0, 1), 'U': (1, 0), 'D': (-1, 0)}
        for m in moves:
            start[0] += jump[m][0]
            start[1] += jump[m][1]

        return start == [0, 0]
