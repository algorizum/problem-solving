# 561. Array Partition I
# https://leetcode.com/problems/array-partition-i/description/


class Solution:
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        res = 0
        nums = sorted(nums)
        for idx in range(0, len(nums), 2):
            res += min(nums[idx], nums[idx + 1])
        return res
