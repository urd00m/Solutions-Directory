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
    int idx; 
    int ret; 
    int kthSmallest(TreeNode* root, int k) {
        //recursive dfs 
        Solution::idx = 0; 
        Solution::ret = -1; 
        dfs(root, k); 
        return Solution::ret; 
    }
    
    void dfs(TreeNode* cur, int k) {
        if(cur == nullptr) {
            return; 
        }
        
        dfs(cur->left, k);
        Solution::idx++;  
        if(Solution::idx == k) {
            Solution::ret = cur->val; 
        }
        dfs(cur->right, k);
    }
};
