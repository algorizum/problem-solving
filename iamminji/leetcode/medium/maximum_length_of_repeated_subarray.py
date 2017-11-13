# 718. Maximum Length of Repeated Subarray
# https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/


class Solution(object):
    def findLength(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: int
        """

        dp = [[0 for _ in range(len(B))] for _ in range(len(A))]

        for idx in range(len(A)):
            for jdx in range(len(B)):
                if idx < 1 or jdx < 1:
                    if A[idx] == B[jdx]:
                        dp[idx][jdx] = 1
                    else:
                        dp[idx][jdx] = 0
                else:
                    if A[idx] == B[jdx]:
                        dp[idx][jdx] = dp[idx - 1][jdx - 1] + 1
                    else:
                        dp[idx][jdx] = 0

        return max([max(sub_array) for sub_array in dp])


if __name__ == "__main__":
    # python2
    pass
