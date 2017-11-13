# 461. Hamming Distance
# https://leetcode.com/problems/hamming-distance/description/


class Solution:
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """

        res = 0
        for n in bin(x ^ y)[2:]:
            if n == '1':
                res += 1
        return res


if __name__ == "__main__":
    sol = Solution()
    print(sol.hammingDistance(3, 3))
