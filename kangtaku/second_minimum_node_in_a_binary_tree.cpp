/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int findSecondMinimumValue(TreeNode* root) {
        int left = findMin(root->left, root->val);
        int right = findMin(root->right, root->val);
        if ((left == INT_MAX && right == INT_MAX) || min(left, right) == root->val) {
            return -1;
        } else {
            return min(left, right);
        }
    }
    
    int findMin(TreeNode* root, int now) {
        if (root == NULL) return INT_MAX;
        if (now < root->val) {
            return root->val;
        }
        return min(findMin(root->left, now), findMin(root->right, now));
    }
};