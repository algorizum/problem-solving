# 75. Sort Colors
# https://leetcode.com/problems/sort-colors/description/


# Python2
class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """

        c0, c1, c2 = 0, 0, 0

        for num in nums:
            if num == 0:
                c0 += 1
            elif num == 1:
                c1 += 1
            else:
                c2 += 1

        for idx, num in enumerate(nums):
            if idx < c0:
                nums[idx] = 0
            elif idx < c0 + c1:
                nums[idx] = 1
            else:
                nums[idx] = 2


if __name__ == "__main__":
    sol = Solution()
    print sol.sortColors([1, 1, 0, 0, 0, 2])
