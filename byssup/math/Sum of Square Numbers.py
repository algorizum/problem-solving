import math

class Solution(object):
    def judgeSquareSum(self, c):
        """
        :type c: int
        :rtype: bool
        """

        i = 0
        while i <= math.sqrt(c):
            val = math.sqrt(c - pow(i, 2))
            if val == math.ceil(val):
                return True
            i += 1
        return False