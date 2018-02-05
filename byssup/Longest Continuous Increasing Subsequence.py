import bisect

class Solution(object):
    def findLengthOfLCIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        new_nums = []
        count = []
        for num in nums:
            i = bisect.bisect_left(new_nums, num)
            if not new_nums:
                new_nums.append(num)
                count.append(1)
            elif i == 0:
                new_nums[0] = num
            elif i >= len(new_nums):
                new_nums.append(num)
                count.append(count[-1] + 1)
            else:
                if count[i-1] + 1 >= count[i]:
                    new_nums[i] = num
                else:
                    new_nums.insert(i, num)
                    count.insert(i, count[i] + 1)
        return count[-1]