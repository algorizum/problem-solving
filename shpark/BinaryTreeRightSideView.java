import java.util.*;

public class BinaryTreeRightSideView {
	/*public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result=new ArrayList<>();
		Queue<TreeNode> queue=new LinkedList<>();
		if(root!=null)queue.add(root);
		while(!queue.isEmpty()){
			int cnt=queue.size();
			TreeNode node=null;
			for(int i=0; i<cnt;i++){
				node=queue.poll();
				if(node.left!=null)queue.add(node.left);
				if(node.right!=null)queue.add(node.right);
			}
			if(node!=null)result.add(node.val);
		}
		return result;
	}*/
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result=new ArrayList<>();
		dfs(result,root,0);
		return result;
	}
	public void dfs(List<Integer> result,TreeNode root, int h){
		if(root==null)return;
		h++;
		if(result.size()<h)
			result.add(root.val);
		else result.set(h-1, root.val);
		dfs(result,root.left,h);
		dfs(result,root.right,h);
		h--;
	}
}
