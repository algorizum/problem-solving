
public class SumRoottoLeafNumbers {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val=x;}
	}
	
	public int sumNumbers(TreeNode root){
		return getLeaf(root,0);
	}
	public int getLeaf(TreeNode root, int sum){
		if(root==null)return 0;
		sum*=10;
		sum+=root.val;
		if(root.left==null && root.right==null){return sum;}
		return getLeaf(root.left,sum)+getLeaf(root.right,sum);	
	}
}
