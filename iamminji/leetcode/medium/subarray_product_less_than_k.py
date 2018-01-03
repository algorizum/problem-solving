# 713. Subarray Product Less Than K
# https://leetcode.com/problems/subarray-product-less-than-k/description/

from collections import deque


class Solution:
    def numSubarrayProductLessThanK(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """

        mul = 1
        idx = 0
        jdx = 0
        count = 0
        queue = deque()

        while idx < len(nums):
            if jdx > len(nums) - 1:
                break
            if mul * nums[idx] < k:
                queue.append(nums[idx])
                mul = mul * nums[idx]
                idx += 1
            else:
                count += len(queue)
                if queue:
                    prev = queue.popleft()
                    mul = mul / prev
                else:
                    idx += 1
                jdx += 1

        remain = len(queue)
        while remain > 0:
            count += len(queue)
            _ = queue.popleft()
            remain -= 1

        return count


if __name__ == "__main__":
    sol = Solution()
    print(sol.numSubarrayProductLessThanK([1, 1, 111, 1], 3))
