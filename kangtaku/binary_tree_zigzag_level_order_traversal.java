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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<Dt> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        q.add(new Dt(0, root));
        while(!q.isEmpty()){
            Dt head=q.poll();
            if(head.node==null)continue;
            if(ans.size()==head.depth){
                ans.add(new ArrayList<>());
            }
            ans.get(head.depth).add(head.node.val);
            q.add(new Dt(head.depth+1,head.node.left));
            q.add(new Dt(head.depth+1,head.node.right));
        }
        for(int i=1;i<ans.size();i+=2){
            Collections.reverse(ans.get(i));
        }
        return ans;
    }
}

class Dt {
    int depth;
    TreeNode node;
    Dt(int depth, TreeNode node) {this.depth=depth;this.node=node;}
}
