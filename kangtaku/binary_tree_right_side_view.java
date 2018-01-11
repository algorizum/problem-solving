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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        find(ans,root,0);
        return ans;
    }
    public void find(List<Integer> ans,TreeNode root,int depth){
        if(root==null)return;
        if(ans.size()==depth)ans.add(0);
        ans.set(depth,root.val);
        find(ans,root.left,depth+1);
        find(ans,root.right,depth+1);
    }
}
