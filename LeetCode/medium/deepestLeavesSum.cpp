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
    int max_depth; 
    int sum; 
    int deepestLeavesSum(TreeNode* root) {
        Solution::max_depth = -1; 
        Solution::sum = 0; 
        dfs(root, 0); 
        
        return Solution::sum; 
    }
    
    void dfs(TreeNode* cur, int depth) {
        if(cur == nullptr) 
            return; 
        
        if(depth > Solution::max_depth) {
            Solution::sum = cur->val; 
            Solution::max_depth = depth; 
        }
        else if(depth == Solution::max_depth) {
            Solution::sum += cur->val; 
        }
        
        dfs(cur->left, depth+1);
        dfs(cur->right, depth+1);
    }
};
