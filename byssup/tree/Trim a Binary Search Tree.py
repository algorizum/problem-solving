class Solution(object):
    def trimBST(self, root, L, R):
        """
        :type root: TreeNode
        :type L: int
        :type R: int
        :rtype: TreeNode
        """
        nums = self.get_nums(root, L, R)
        new_root = None
        for num in nums:
            if not new_root:
                new_root = TreeNode(num)
            else:
                self.add_node(new_root, num)
        return new_root

    def get_nums(self, node, L, R):
        res = []
        if node:
            if L <= node.val <= R:
                res.append(node.val)
            res.extend(self.get_nums(node.left, L, R))
            res.extend(self.get_nums(node.right, L, R))
        return res

    def add_node(self, node, num):
        if num > node.val:
            if not node.right:
                node.right = TreeNode(num)
            else:
                self.add_node(node.right, num)
        else:
            if not node.left:
                node.left = TreeNode(num)
            else:
                self.add_node(node.left, num)