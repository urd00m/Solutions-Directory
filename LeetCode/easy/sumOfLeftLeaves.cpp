/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int sumOfLeftLeaves(TreeNode* root) {
        return recur(root, false); 
    }
    
    int recur(TreeNode* cur, bool left) {
        if(cur == nullptr) return 0;
        if(cur->left == nullptr && cur->right == nullptr && left == true) return cur->val; 
        else if (cur->left == nullptr && cur->right == nullptr && left == false) return 0; 
        
        return recur(cur->left, true) + recur(cur->right, false); 
    }
};

//< 5 minutes

