# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def findTarget(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: bool
        """
        nums = self.get_nums(root)
        while nums:
            num = nums.pop()
            if k - num in nums:
                return True
        return False

    def get_nums(self, node):
        if node:
            res = set()
            res = res.union(self.get_nums(node.left))
            res.add(node.val)
            res = res.union(self.get_nums(node.right))
            return res
        return set()
