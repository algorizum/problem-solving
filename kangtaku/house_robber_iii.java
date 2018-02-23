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
    Map<String, Integer> mp;
    public int rob(TreeNode root) {
        mp = new HashMap<>();
        return dfs(root, true);
    }
    public int dfs(TreeNode root, boolean can) {
        if (root == null) return 0;
        String key = root.toString() + (can ? "Y" : "N");
        if (mp.containsKey(key)) return mp.get(key);
        int res = -1;
        if (can) {
            res = root.val + dfs(root.left, !can) + dfs(root.right, !can);
            res = Math.max(res, dfs(root.left, can) + dfs(root.right, can));
        } else {
            res = dfs(root.left, !can) + dfs(root.right, !can);
        }
        mp.put(key, res);
        return res;
    }
}
