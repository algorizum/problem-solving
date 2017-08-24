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
    int sumOfRoot;
    unordered_map<TreeNode*, int> cache;
public:
    bool checkEqualTree(TreeNode* root) {
        sumOfRoot = sumOfTree(root);
        return solve(root->left) || solve(root->right);
    }
    
    bool solve(TreeNode* root) {
        if (root == NULL) {
            return false;
        }
        
        bool ret = (sumOfTree(root) * 2 == sumOfRoot);
        ret |= (solve(root->left) | solve(root->right));
        return ret;
    }
    
    int sumOfTree(TreeNode* root) {
        if (root == nullptr) return 0;
        
        if (cache.find(root) != cache.end()) {
            return cache[root];
        }
        int res = 0;
        int leftSum = sumOfTree(root->left);
        int rightSum = sumOfTree(root->right);
        res = leftSum + root->val + rightSum;
        cache[root] = res;
        return res;
    }
};