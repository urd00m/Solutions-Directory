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
    string tree2str(TreeNode* root) {
        // dfs    
        return dfs(root); 
    }
    
    string dfs(TreeNode* cur) {
        if(!cur) return ""; 
        
        string ret = ""; 
        ret += to_string(cur->val); 
        
        if(cur->right || cur->left) ret += "(" + dfs(cur->left) + ")"; //no matter what add this 
        if(cur->right) ret += "(" + dfs(cur->right) + ")"; 
        
        return ret; 
    }
};
