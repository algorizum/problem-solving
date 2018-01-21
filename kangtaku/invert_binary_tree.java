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
    public TreeNode invertTree(TreeNode root) {
        if (root != null) helper(root);
        return root;
    }
    
    public void helper(TreeNode root) {
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        if (root.left != null) helper(root.left);
        if (root.right != null) helper(root.right);
    }
}
