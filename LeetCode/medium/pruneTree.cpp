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
    TreeNode* pruneTree(TreeNode* root) {
        // recursion 
        bool status = dfs(root);
        if(status == false) return nullptr; 
        return root; 
    }
    
    static bool dfs(TreeNode* cur) {
        if(cur == nullptr) return false; 
        
        bool left_status = dfs(cur->left);
        bool right_status = dfs(cur->right);
        
        if(left_status == false) cur->left = nullptr; 
        if(right_status == false) cur->right = nullptr;
        
        if(left_status == false && right_status == false && cur->val != 1) return false;
        return true;
    }
};
