class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if sum(nums) % 2 != 0:
            return False

        arr = [0 for _ in range(sum(nums) / 2 + 1)]

        arr[0] = 1
        nums = sorted(nums)
        for num in nums:
            for idx in range(len(arr) - 1, -1, -1):
                if arr[idx] == 1:
                    if idx + num >= len(arr):
                        continue
                    arr[idx + num] = 1

        return arr[-1] == 1