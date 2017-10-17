# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findSecondMinimumValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        nums = set()
        self.rec(root, nums)
        nums = list(nums)
        nums.sort()
        if len(nums) < 2:
            return -1
        return nums[1]

    def rec(self, node, nums):
        if node:
            nums.add(node.val)
            self.rec(node.left, nums)
            self.rec(node.right, nums)