## Solved By Solution

class Solution(object):
    def maxSumOfThreeSubarrays(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        sum_list = [sum(nums[:k])]
        for i, num in enumerate(nums[k:]):
            sum_list.append(-1 * nums[i] + sum_list[-1] + num)

        left = [0] * len(sum_list)
        best = 0
        for i in range(len(sum_list)):
            if sum_list[i] > sum_list[best]:
                best = i
            left[i] = best

        right = [0] * len(sum_list)
        best = len(sum_list) - 1
        for i in range(len(sum_list) - 1, -1, -1):
            if sum_list[i] > sum_list[best]:
                best = i
            right[i] = best

        ans = []
        for i in range(k, len(sum_list)-k):
            if not ans or sum_list[left[i-k]] + sum_list[i] + sum_list[right[i+k]] > sum_list[ans[0]] + sum_list[ans[1]] + sum_list[ans[2]]:
                ans = [left[i-k], i, right[i+k]]
        return ans