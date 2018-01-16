# 103. Binary Tree Zigzag Level Order Traversal
# https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

from collections import defaultdict


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """

        cache = defaultdict(list)
        max_depth = -1

        stack = [(root, 0)]
        while stack:
            node, depth = stack.pop()

            if node is not None:
                max_depth = max(max_depth, depth)

                cache[depth].append(node.val)

                stack.append((node.left, depth + 1))
                stack.append((node.right, depth + 1))

        return [cache[depth][::-1] if depth % 2 == 0 else cache[depth] for depth in range(max_depth + 1)]
