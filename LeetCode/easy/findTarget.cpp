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
    unordered_map<int, bool> exists; 
    bool findTarget(TreeNode* root, int k) {
        // unordered map plus traversal
        Solution::exists.clear(); 
        
        // dfs 
        return dfs(root, k); 
    }
    
    bool dfs(TreeNode *cur, int target) {
        if(!cur) return false; 
        
        bool ret = Solution::exists[target-cur->val]; 
        exists[cur->val] = true;
        ret |= dfs(cur->left, target) || dfs(cur->right, target);
        return ret; 
    }
};
