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
    public int sumNumbers(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return dfs(root, sb);
    }
    
    int dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return 0;
        }
        int res;
        sb.append(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            res = Integer.valueOf(sb.toString());
        } else {
            res = dfs(root.left, sb) + dfs(root.right, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
        return res;
    }
}
