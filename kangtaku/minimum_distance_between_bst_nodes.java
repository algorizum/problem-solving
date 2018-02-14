
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
    
    public int minDiffInBST(TreeNode root) {
        Set<Integer> st = new TreeSet<>();
        find(st, root);
        Iterator<Integer> itr = st.iterator();
        int first = itr.next();
        int second;
        int res = Integer.MAX_VALUE;
        while(itr.hasNext()) {
            second = first;
            first = itr.next();
            res = Math.min(res, Math.abs(second - first));
        }
        return res;
    }
    
    public void find(Set<Integer> st, TreeNode root){
        if(root==null)return;
        st.add(root.val);
        find(st, root.left);
        find(st, root.right);
    }
}
