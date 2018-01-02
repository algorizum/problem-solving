# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """
        if not t1:
            return t2
        elif not t2:
            return t1

        idx_dict = dict()
        self.get_idx(idx_dict, 1, t2)
        self.create_tree(idx_dict, 1, t1)
        return t1

    def get_idx(self, idx_dict, idx, node):
        if node:
            idx_dict[idx] = node.val
            self.get_idx(idx_dict, idx * 2, node.left)
            self.get_idx(idx_dict, idx * 2 + 1, node.right)

    def create_tree(self, idx_dict, idx, node):
        if node:
            if idx in idx_dict:
                node.val += idx_dict[idx]
                idx_dict.pop(idx)

            if not node.left and idx * 2 in idx_dict:
                node.left = TreeNode(idx_dict[idx * 2])
                idx_dict.pop(idx * 2)

            if not node.right and idx * 2 + 1 in idx_dict:
                node.right = TreeNode(idx_dict[idx * 2 + 1])
                idx_dict.pop(idx * 2 + 1)

            self.create_tree(idx_dict, idx * 2, node.left)
            self.create_tree(idx_dict, idx * 2 + 1, node.right)
