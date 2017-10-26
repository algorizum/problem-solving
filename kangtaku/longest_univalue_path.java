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
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        int left = (root.left != null && root.left.val == root.val) ? longest(root.left) + 1 : 0;
        int right = (root.right != null && root.right.val == root.val) ? longest(root.right) + 1 : 0;
        ans =  Math.max(ans, left + right);
        ans = Math.max(ans, longestUnivaluePath(root.left));
        ans = Math.max(ans, longestUnivaluePath(root.right));
        return ans;
    }
    
    public int longest(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        if (root.left != null && root.val == root.left.val) {
            ans = Math.max(ans, longest(root.left) + 1);
        }
        
        if (root.right != null && root.val == root.right.val) {
            ans = Math.max(ans, longest(root.right) + 1);
        }
        return ans;
    }
}
