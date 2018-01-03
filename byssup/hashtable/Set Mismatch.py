class Solution(object):
    def findErrorNums(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        count_list = [0] * (len(nums) + 1)
        for num in nums:
            count_list[num] += 1
        res = [0,0]
        for i, count in enumerate(count_list[1:]):
            if count == 0:
                res[1] = i + 1
            elif count == 2:
                res[0] = i + 1
        return res