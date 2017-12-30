
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return root==null?true:isEqual(reverseNode(root.left), root.right);
	}

	private boolean isEqual(TreeNode root1, TreeNode root2) {
		if(root1==null &&root2==null)return true;
		else if(root1==null || root2==null)return false;
		
		
		return root1.val==root2.val && isEqual(root1.left,root2.left) &&isEqual(root1.right,root2.right);
	}
	
	public TreeNode reverseNode(TreeNode root){
		if(root==null)return null;
		
		TreeNode tmp=root.left;
		root.left=reverseNode(root.right);
		root.right=reverseNode(tmp);
		
		return root;
	}
}
