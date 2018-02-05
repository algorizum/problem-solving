/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
		root=helper(root,L,R);
		return root;
	}

public TreeNode helper(TreeNode root, int L, int R) {
		if (root == null)
			return null;
		if (root.val >= L && root.val <= R) {
			root.left=helper(root.left, L, R);
			root.right=helper(root.right, L, R);
		} else {
			TreeNode tmp=helper(root.left, L, R);
			if (tmp == null) {
				root = helper(root.right, L, R);
			}else{
				root=tmp;
			}
		}
		return root;
	}
	
}