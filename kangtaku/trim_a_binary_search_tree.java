/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        TreeNode newTree = null;
        if (L <= root.val && root.val <= R) {
            if (newTree == null) newTree = new TreeNode(root.val);
            newTree.left = trimBST(root.left, L, R);
            newTree.right = trimBST(root.right, L, R);
        } else {
            newTree = trimBST(root.left, L, R);
            if (newTree == null) {
                newTree = trimBST(root.right, L, R);
            }
        }
        return newTree;
    }
}

