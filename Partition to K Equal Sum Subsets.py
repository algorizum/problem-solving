import math

class Solution(object):
    def canPartitionKSubsets(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        nums.sort()
        return self.solve(nums, k, [])

    def solve(self, nums, k, ans):
        if k == 0:
            if ans[0] == ans[1] == ans[2] == ans[3]:
                return True
            return False
        is_found = False
        mid = int(math.ceil(len(nums) / 2))
        for i in range(1, mid + 1):
            if not is_found:
                ans.append(sum(nums[mid - i:mid]))
                is_found = self.solve(nums[:mid - i] + nums[mid:], k - 1, ans)
                ans.pop()

            if not is_found:
                ans.append(sum(nums[mid: mid + i]))
                is_found = self.solve(nums[:mid] + nums[mid + i:], k - 1, ans)
                ans.pop()
        return is_found

if __name__ == '__main__':
    nums = [4, 3, 2, 3, 5, 2, 1]
    k = 4
    sol = Solution()
    print(sol.canPartitionKSubsets(nums, k))