class Solution(object):
    def checkPossibility(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        i, j = self.get_idx(nums)
        if not i and not j:
            return True
        for k in [i, j]:
            ii, jj = self.get_idx(nums[:k] + nums[k + 1:])
            if not ii and not jj:
                return True
        return False

    def get_idx(self, nums):
        i = 0
        for j, num in enumerate(nums):
            if nums[i] > num:
                return i, j
            i = j
        return None, None
