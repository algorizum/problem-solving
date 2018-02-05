class Solution(object):
    def constructArray(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[int]
        """
        nums = [nn for nn in range(2, n + 1)]
        res = [1]
        while len(res) < k:
            if len(res) % 2 == 1:
                res.append(nums.pop(-1))
            else:
                res.append(nums.pop(0))

        if len(res) % 2 == 0:
            nums.reverse()
        res.extend(nums)
        return res