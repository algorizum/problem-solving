# 441. Arranging Coins
# https://leetcode.com/problems/arranging-coins/

# python3

from math import sqrt, floor


class Solution:
    def arrangeCoins(self, n):
        """
        :type n: int
        :rtype: int
        """

        return floor((-1 + sqrt(1 + 8 * n)) / 2) if n > 1 else n
