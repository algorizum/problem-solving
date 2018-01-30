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
    TreeNode* invertTree(TreeNode* root) {
        if(root==NULL)
            return NULL;
        
        TreeNode* left_temp = invertTree(root->right);
        TreeNode* right_temp = invertTree(root->left);
        
        root->left = left_temp;
        root->right = right_temp;
                
        return root;
    }
};
