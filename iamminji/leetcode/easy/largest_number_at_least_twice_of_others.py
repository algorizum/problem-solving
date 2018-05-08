# 747. Largest Number At Least Twice of Others
# https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/


class Solution:
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        max_num = max(nums)
        res = -1
        for i, num in enumerate(nums):
            if num == max_num:
                res = i
            elif num * 2 > max_num:
                res = -1
                break
        return res
