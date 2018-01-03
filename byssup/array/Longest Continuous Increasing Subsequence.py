class Solution(object):
    def findLengthOfLCIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        res =  1
        temp = 1
        for i, num in enumerate(nums[:-1]):
            if nums[i] < nums[i + 1]:
                temp += 1
            else:
                res = max(res, temp)
                temp = 1
        res = max(res, temp)
        return res