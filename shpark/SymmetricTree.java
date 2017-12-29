
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return compareNode(root, root);
	}

	public boolean compareNode(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null)
			return root1 == null && root2 == null ? true : false;

		if (root1.val != root2.val)
			return false;
		else {
			return compareNode(root1.left, root2.right) && compareNode(root1.right, root2.left);
		}
	}
}
