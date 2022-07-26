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
    TreeNode* ret; 
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        Solution::ret = nullptr; 
        
        //dfs
        dfs(root, p, q);
        
        return Solution::ret; 
    }
    
    bool dfs(TreeNode* cur, TreeNode* p, TreeNode* q) {
        if(cur == nullptr) return false; 
        
        bool left = dfs(cur->left, p, q); 
        bool right = dfs(cur->right, p, q); 
        if(Solution::ret == nullptr && (left || right) && (cur == p || cur == q)) 
            Solution::ret = cur; 
        else if(Solution::ret == nullptr && left && right)
            Solution::ret = cur; 
        
        if(cur == p || cur == q) return true; 
        
        return left || right; 
    }
};
