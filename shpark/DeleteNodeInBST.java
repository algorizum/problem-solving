
public class DeleteNodeInBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;
		if(root.val==key){
			return insertNode(root.right,root.left);
		}else if(root.val<key){ root.right=deleteNode(root.right,key);}
		else {root.left=deleteNode(root.left,key);}

		return root;
	}
	
	public TreeNode insertNode(TreeNode root,TreeNode insertNode){
        
		if(insertNode==null || root==null)
			return insertNode==null?root:insertNode;
		if(root.val<insertNode.val){
			root.right=insertNode(root.right,insertNode);
		}else{
			root.left=insertNode(root.left,insertNode);
		}
		return root;
	}
}
