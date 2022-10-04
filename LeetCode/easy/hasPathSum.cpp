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
    bool hasPathSum(TreeNode* root, int targetSum) {
        return dfs(root, targetSum);
    }
    
    bool dfs(TreeNode* cur, int targetSum) {
        if(cur == nullptr) return false; 
        if(cur->left == nullptr && cur->right == nullptr) { // leaf node
            if(targetSum == cur->val) return true; 
            else return false;
        }
        
        return dfs(cur->left, targetSum-cur->val) || dfs(cur->right, targetSum-cur->val); 
    }
};
