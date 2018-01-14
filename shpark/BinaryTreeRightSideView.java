import java.util.*;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
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
	}
}
