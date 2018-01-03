import math

class Solution(object):
    def repeatedStringMatch(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: int
        """

        count = max(1, len(B) / len(A))

        if (A * count).find(B) >= 0:
            return count
        if (A * (count + 1)).find(B) >= 0:
            return count + 1
        return -1