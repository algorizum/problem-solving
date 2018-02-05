class Solution(object):
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        sum_val = 0
        for i in range(0, len(nums), 2):
            sum_val += min(nums[i], nums[i + 1])
        return sum_val