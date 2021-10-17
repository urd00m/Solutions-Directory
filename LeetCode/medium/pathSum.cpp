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
    int pathSum(TreeNode* root, int targetSum) {
        // Vector with all the sums of the past dfs search 
        vector<int> temp; 
        return dfs(root, targetSum, temp); 
    }
    
    int dfs(TreeNode* cur, int targetSum, vector<int>& sums) {
        //if it equals the target sum 
        if(cur == nullptr) return 0;
        
        int ret = 0; 
        for(long i = 0; i < sums.size(); i++) {
            sums[i] += cur->val; 
            if(sums[i] == targetSum) ret++; 
        }
        sums.push_back(cur->val); 
        if(cur->val == targetSum) ret++; 
        
        ret += dfs(cur->left, targetSum, sums);
        ret += dfs(cur->right, targetSum, sums);
        
        sums.pop_back(); 
        for(long i = 0; i < sums.size(); i++) {
            sums[i] -= cur->val; 
        }
        
        return ret; 
    }
};
