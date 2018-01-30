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
        typedef struct StackNode {
            TreeNode* parent;
            TreeNode* cur;
            bool isLeft;
        } StackNode;
        
        StackNode stack[10000];
        int top = 1;
        
        if(root==NULL)
            return NULL;
        
        stack[0].cur = root->left;
        stack[0].parent = root;
        stack[0].isLeft = true;
        stack[1].cur = root->right;
        stack[1].parent = root;
        stack[1].isLeft = false;
        
        while(top>=0)
        {
            TreeNode* parent = stack[top].parent;
            TreeNode* cur = stack[top].cur;
            bool isLeft = stack[top].isLeft;
            top -= 1;
            
            if(isLeft)
                parent->right = cur;
            else
                parent->left = cur;
            
            if(cur!=NULL)
            {
                stack[top+1].cur = cur->left;
                stack[top+1].parent = cur;
                stack[top+1].isLeft = true;
                stack[top+2].cur = cur->right;
                stack[top+2].parent = cur;
                stack[top+2].isLeft = false;
                top += 2;
            }
        }
        
        return root;

    }
};
