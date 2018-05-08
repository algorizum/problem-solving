import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result=new ArrayList<>();
		Queue<TreeNode> queue=new LinkedList<>();
		if(root!=null)queue.add(root);
		while(!queue.isEmpty()){
			int size=queue.size();
			LinkedList<Integer> stage=new LinkedList<>();
			for(int i=0; i<size; i++){
				TreeNode node=queue.poll();
				if(node.left!=null)queue.add(node.left);
				if(node.right!=null)queue.add(node.right);
				
				if(result.size()%2==0)stage.add(node.val);
				else stage.addFirst(node.val);
				
			}
			result.add(stage);
		}
		return result;
	}
}
