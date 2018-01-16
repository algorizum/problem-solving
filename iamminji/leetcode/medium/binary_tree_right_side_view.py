# 199. Binary Tree Right Side View
# https://leetcode.com/problems/binary-tree-right-side-view/description/


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def rightSideView(self, root):
        cache = dict()
        max_depth = -1

        stack = [(root, 0)]
        while stack:
            node, depth = stack.pop()

            if node is not None:
                max_depth = max(max_depth, depth)

                if depth not in cache:
                    cache[depth] = node.val

                stack.append((node.left, depth + 1))
                stack.append((node.right, depth + 1))

        return [cache[depth] for depth in range(max_depth + 1)]
