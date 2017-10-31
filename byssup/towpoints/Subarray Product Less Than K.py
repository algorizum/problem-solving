class Solution(object):
    def numSubarrayProductLessThanK(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        total = 1
        head, count = 0, 0
        res_count = 0
        for tail, num in enumerate(nums):
            if total * num < k:
                total *= num
                count += 1
                res_count += count
            else:
                while head < tail and total * num >= k:
                    total /= nums[head]
                    head += 1
                    count -= 1

                if total * num < k:
                    count += 1
                    total *= num
                    res_count += count
                else:
                    head += 1
        return res_count