public class LongestUnivaluePath {
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        int longestPathLength = 0;
        if(root.left != null && root.val == root.left.val) {
            longestPathLength += (1 + getLongestSubPath(root.left));
        }
        if(root.right != null && root.val == root.right.val) {
            longestPathLength += (1 + getLongestSubPath(root.right));
        }
        longestPathLength = Math.max(longestPathLength, longestUnivaluePath(root.left));
        longestPathLength = Math.max(longestPathLength, longestUnivaluePath(root.right));
        return longestPathLength;
    }
    private int getLongestSubPath(TreeNode subRoot) {
        int tmpLength1 = 0, tmpLength2 = 0;
        if(subRoot.left != null && subRoot.val == subRoot.left.val) {
            tmpLength1 = 1 + getLongestSubPath(subRoot.left);
        }
        if(subRoot.right != null && subRoot.val == subRoot.right.val) {
            tmpLength2 = 1 + getLongestSubPath(subRoot.right);
        }
        return Math.max(tmpLength1, tmpLength2);
    }
    public static void main(String[] args) {
    	LongestUnivaluePath solution = new LongestUnivaluePath();

        TreeNode root = new TreeNode(5); //2
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(solution.longestUnivaluePath(root));
    }
}
