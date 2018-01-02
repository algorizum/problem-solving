# 617. Merge Two Binary Trees
# https://leetcode.com/problems/merge-two-binary-trees/description/


class Solution:
    def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """

        if t1 is None and t2 is None:
            return None

        if t1 is not None:
            lval = t1.val
            t1left = t1.left
            t1right = t1.right
        else:
            lval = 0
            t1left = None
            t1right = None

        if t2 is not None:
            rval = t2.val
            t2left = t2.left
            t2right = t2.right
        else:
            rval = 0
            t2left = None
            t2right = None

        tree = TreeNode(lval + rval)

        tree.left = self.mergeTrees(t1left, t2left)
        tree.right = self.mergeTrees(t1right, t2right)

        return tree
