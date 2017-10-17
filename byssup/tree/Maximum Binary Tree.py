# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def constructMaximumBinaryTree(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        return self.create_tree(nums)

    def create_tree(self, nums):
        if nums:
            i, num = self.get_max(nums)
            tree = TreeNode(num)
            tree.left = self.create_tree(nums[:i])
            tree.right = self.create_tree(nums[i + 1:])
            return tree
        return None

    def get_max(self, nums):
        ii = -1
        nnum = None
        for i, num in enumerate(nums):
            if ii < 0:
                ii, nnum = i, num
            elif num > nnum:
                ii, nnum = i, num
        return ii, nnum
