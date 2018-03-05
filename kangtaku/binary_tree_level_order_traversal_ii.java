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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, ans, 0);
        Collections.reverse(ans);
        return ans;
    }
    
    public void dfs(TreeNode root, List<List<Integer>> ans, int depth) {
        if (root == null) return;
        if (ans.size() == depth) {
            List<Integer> row = new ArrayList<>();
            ans.add(row);
        }
        List<Integer> row = ans.get(depth);
        row.add(root.val);
        dfs(root.left, ans, depth + 1);
        dfs(root.right, ans, depth + 1);
    }
}
